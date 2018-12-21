package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.ExcelPOIUtils;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveDataEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveInfoEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveWeightMatrixEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.AHPComputeWeight;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveDataService;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveInfoService;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveWeightMatrixService;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 满意度调查
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
@RestController
@RequestMapping("/pm/approve")
public class ApproveController extends AbstractController {
	@Autowired
	private ApproveWeightMatrixService approveWeightMatrixService;
	@Autowired
    private ApproveInfoService approveInfoService;
    @Autowired
    private ApproveDataService approveDataService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:approve:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ApproveWeightMatrixEntity> approveWeightMatrixList = approveWeightMatrixService.queryList(query);
		int total = approveWeightMatrixService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(approveWeightMatrixList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:approve:info")
	public R info(@PathVariable("id") Long id){
		ApproveWeightMatrixEntity approveWeightMatrix = approveWeightMatrixService.queryObject(id);
		
		return R.ok().put("approveWeightMatrix", approveWeightMatrix);
	}
	
	/**
	 * 保存权重
	 */
	@RequestMapping("/saveweight")
	@RequiresPermissions("pm:approve:save")
	public R saveWeight(@RequestBody List<Map<?, ?>> datas){

		String k = "";
		String v = "";
		Integer bigCateId = 1;
        Map<String, String> dataMap = new TreeMap();

        // 排好了序
        for (Map<?, ?> m : datas){
            k = v = "";
            // 每一条数据...
            for (Map.Entry entry : m.entrySet()){
                if (entry.getKey().equals("key")){
                    k = entry.getValue().toString();
                }else if (entry.getKey().equals("value")){
                	v = entry.getValue().toString().equals("1/1") ? "1" : entry.getValue().toString();
                }else if (entry.getKey().equals("bigCateId")){
                    bigCateId = Integer.valueOf(entry.getValue().toString());
                }
            }
            dataMap.put(k, v);
        }

        // 较验 是否有效
        Double d[][] = new Double[(int)Math.sqrt(dataMap.size())][];
        List<Double> _list = new LinkedList<>();
        String str;
        double _v;
        int i = 1;
        for (Map.Entry entry : dataMap.entrySet()){
            str = entry.getValue().toString();
            if (str.split("\\/").length > 1){
                try {
                    _v = Double.valueOf(str.split("\\/")[0]) / Double.valueOf(str.split("\\/")[1]);
                }catch(Exception e){
                    return R.error("指标参数错误！！");
                }
            }else{
                _v = Double.valueOf(str);
            }
            _list.add(_v);

            if (i % Math.sqrt(dataMap.size()) == 0){
                int kone = (int) (i/Math.sqrt(dataMap.size())) - 1;
                d[kone] = _list.toArray(new Double[_list.size()]);
                _list = new LinkedList<>();
            }
            i++;
        }
        AHPComputeWeight ahpComputeWeight = new AHPComputeWeight(d, 10);
        Map<String, Object> result = ahpComputeWeight.calculate();
        /*System.out.println(result.get("lamta"));
        System.out.println(result.get("CI"));
        System.out.println(result.get("CR"));
        double[] weight = (double[]) result.get("weight");
        System.out.println("权重向量:");
        for (double _i : weight) {
            System.out.print(_i + " ");
            System.out.println();
        }*/
        if ((double)result.get("CR") > 0.1){
            return R.error("指标参数错误！");
        }


        // 输出二维数组
        /*for (int _k=0;_k<d.length;_k++){
            for (int _kk = 0; _kk<d[_k].length; _kk++){
                System.out.println(d[_k][_kk]);
            }
            System.out.println("--------");
        }*/


        // 入库
        Map params = new HashMap<>();
        for (Map.Entry entry : dataMap.entrySet()){

            params.put("bigCategory", bigCateId);
            params.put("smallCategoryX", Integer.valueOf(entry.getKey().toString().split("_")[0]));
            params.put("smallCategoryY", Integer.valueOf(entry.getKey().toString().split("_")[1]));
            ApproveWeightMatrixEntity entity = approveWeightMatrixService.queryObjectByCate(params);
            if (entity == null){
                entity = new ApproveWeightMatrixEntity();
                entity.setBigCategory(bigCateId);
                entity.setSmallCategoryX(Integer.valueOf(entry.getKey().toString().split("_")[0]));
                entity.setSmallCategoryY(Integer.valueOf(entry.getKey().toString().split("_")[1]));
                entity.setCreateAdminid(getUserId());
                entity.setCreateDate(DateUtils.getTodayDate());
                entity.setAmount(entry.getValue().toString());
                approveWeightMatrixService.save(entity);
            }else{
                entity.setAmount(entry.getValue().toString());
                approveWeightMatrixService.update(entity);
            }

        }

		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:approve:update")
	public R update(@RequestBody ApproveWeightMatrixEntity approveWeightMatrix){
        ValidatorUtils.validateEntity(approveWeightMatrix, UpdateGroup.class);
		approveWeightMatrixService.update(approveWeightMatrix);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:approve:delete")
	public R delete(@RequestBody Long[] ids){
		approveWeightMatrixService.deleteBatch(ids);
		
		return R.ok();
	}


	/**
	 * 信息
	 */
	@RequestMapping("/getsmallcate/{id}")
    @AuthIgnore
	public R getSmallCate(@PathVariable("id") String id){



        return R.ok();
	}




    /**
     * 上传
     */
    @RequestMapping("/save")
    @RequiresPermissions("pm:approve:save")
    public R save(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        // 非题目答案的 列数，前6列
        int noValidCol = 6;

        List<String[]> lists;
        try {
            lists = ExcelPOIUtils.readExcel(file, 0);

            // 保存基础信息
            ApproveInfoEntity entity = new ApproveInfoEntity();
            entity.setTitle(request.getParameter("title").toString());
            entity.setScope(request.getParameter("scope").toString());
            entity.setSendAmount(Integer.valueOf(request.getParameter("sendAmount").toString()));
            entity.setRecycleAmount(Integer.valueOf(request.getParameter("recycleAmount").toString()));
            entity.setSendDate(request.getParameter("sendDate").toString());
            entity.setRecycleDate(request.getParameter("recycleDate").toString());
            entity.setInitiator(request.getParameter("initiator").toString());
            entity.setExecutor(request.getParameter("executor").toString());
            entity.setRemark(request.getParameter("remark").toString());
            entity.setCreateAdminid(getUserId());
            entity.setCreateDate(DateUtils.getTodayDate());
            approveInfoService.save(entity);

            // 交换行列后的二维数组
            String[][] strLists = new String[lists.get(0).length][lists.size()];

            // 行
            int k = 0;
            for (String[] datas : lists){
                // 列
                for (int i=0; i<datas.length; i++){
                    strLists[i][k] = "";
                }
                k++;
            }

            // 打印二维数组
            /*for (int _k=0;_k<strLists.length;_k++){
                for (int _kk = 0; _kk<strLists[_k].length; _kk++){
                    System.out.print(strLists[_k][_kk]+",");
                }
                System.out.println("--------");
            }*/

            // 计算 新的每一行(原来的每一列) 的平均分
            int score, validCol;
            // 前6行 (原始的前6列) 不需要处理
            for (int _k = noValidCol; _k < strLists.length; _k++){
                score = 0;
                validCol = 0;
                //System.out.println(_k);
                // 不处理原来的 第一行 - 分类行
                for (int _kk = 1; _kk<strLists[_k].length; _kk++){
                    if (strLists[_k][_kk] != null && !strLists[_k][_kk].equals("null") && !"".equals(strLists[_k][_kk])){
                        strLists[_k][_kk] = strLists[_k][_kk].trim();
                        score += Integer.valueOf(strLists[_k][_kk]);
                        validCol++;
                    }
                    //System.out.print(strLists[_k][_kk]+",");
                }
                //System.out.println();

                // 把空值补上平均值
                for (int _kk = 1; _kk<strLists[_k].length; _kk++){
                    if (strLists[_k][_kk] == null || strLists[_k][_kk].equals("null") || "".equals(strLists[_k][_kk])){
                        strLists[_k][_kk] = ((int)Math.ceil((score+0.0)/validCol))+"";
                    }
                    //System.out.print(strLists[_k][_kk]+",");
                }
                //System.out.println();
            }

            // 入库
            int amount;
            int smallCate;
            long infoId = entity.getId();
            int questionId, userId;
            String userBusiness, bmc, isVip, isVvip, isLighthouse, userKind;
            ApproveDataEntity dataEntity;
            for (int _k = noValidCol; _k < strLists.length; _k++){
                smallCate = Integer.valueOf(strLists[_k][0]);
                for (int _kk = 1; _kk<strLists[_k].length; _kk++){

                    // 分数
                    amount = Integer.valueOf(strLists[_k][_kk]);
                    // 题号
                    questionId = _k - noValidCol + 1;
                    // 用户号
                    userId = _kk;
                    userBusiness = strLists[0][_kk];
                    bmc = strLists[1][_kk];
                    isVip = strLists[2][_kk];
                    isVvip = strLists[3][_kk];
                    isLighthouse = strLists[4][_kk];
                    userKind = strLists[5][_kk];

                    //System.out.println(smallCate+"--"+questionId+"--"+amount+"--"+userId+"--"+userBusiness+"--"+bmc+"--"+isVip+"--"+isVvip+"--"+isLighthouse+"--"+userKind);

                    // 入库
                    dataEntity = new ApproveDataEntity();
                    dataEntity.setInfoId(infoId);
                    dataEntity.setAmount((float)amount);
                    dataEntity.setBmc(bmc);
                    dataEntity.setIsLighthouse(isLighthouse);
                    dataEntity.setIsVip(isVip);
                    dataEntity.setIsVvip(isVvip);
                    dataEntity.setQuestionId(questionId);
                    dataEntity.setSmallCategory(smallCate);
                    dataEntity.setUserBusiness(userBusiness);
                    dataEntity.setUserId(userId);
                    dataEntity.setUserKind(userKind);
                    approveDataService.save(dataEntity);
                }
            }

        }catch (IOException e){
            return R.error(e.getMessage());
        }

        return R.ok();
    }
	
}
