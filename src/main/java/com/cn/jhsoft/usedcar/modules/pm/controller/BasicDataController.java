package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.util.*;

import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalQuestionService;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalResultService;
import com.cn.jhsoft.usedcar.modules.pm.vo.BasicDataEntityCus;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.pm.entity.BasicDataEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.BasicDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * 基础数据
 * 
 * @author chenyi
 * @email hn1987@126.com
 * @date 2017-08-25 11:32:27
 */
@RestController
@RequestMapping("/pm/basicdata")
public class BasicDataController extends AbstractController {
	@Autowired
	private BasicDataService basicDataService;
	@Autowired
	private EvalResultService evalResultService;
	@Autowired
	private EvalQuestionService evalQuestionService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:basicdata:list")
	public List<BasicDataEntity> list(){
		Map<String, Object> map = new HashMap<>();
		List<BasicDataEntity> basicDataList = basicDataService.queryList(map);

		return basicDataList;
	}


	/**
	 * 根据标识得到儿子
	 */
	@RequestMapping("/list/{ename}")
	@AuthIgnore
	public List<BasicDataEntity> list(@PathVariable("ename") String ename){
		List<Long> ids = basicDataService.queryBasicDataIdListByEname(ename);
		for (Long id : ids) {
			Map<String, Object> map = new HashMap<>();
			map.put("parentId", id);
			List<BasicDataEntity> basicDataList = basicDataService.queryList(map);
			return basicDataList;
		}

		return null;
	}


	/**
	 * 根据父id得到儿子
	 */
	@RequestMapping("/list/getchild/{parentId}")
	@AuthIgnore
	public List<BasicDataEntity> list(@PathVariable("parentId") int parentId){
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", parentId);
		List<BasicDataEntity> basicDataList = basicDataService.queryList(map);
		return basicDataList;
	}




	/**
	 * 根据标识得到儿子
	 */
	@RequestMapping("/list2/{ename}")
	@AuthIgnore
	public List<BasicDataEntityCus> list2(@PathVariable("ename") String ename){
		List<Long> ids = basicDataService.queryBasicDataIdListByEname(ename);
		Map<String, Object> evalMap = new HashMap<>();

		for (Long id : ids) {
			Map<String, Object> map = new HashMap<>();
			map.put("parentId", id);
			List<BasicDataEntityCus> basicDataCusList = new LinkedList<>();
			List<BasicDataEntity> basicDataList = basicDataService.queryList(map);
			for (BasicDataEntity entity : basicDataList){
				BasicDataEntityCus bdCus = new BasicDataEntityCus();
				BeanUtils.copyProperties(entity, bdCus);

				// 题目数量
				evalMap.clear();
				evalMap.put("createAdminid", getUserId());
				evalMap.put("type1", entity.getId());
				bdCus.setAllQuestionSum(evalQuestionService.queryTotal2(evalMap));
				// 已答数量
				evalMap.put("type1name", entity.getName());
				bdCus.setAllUnAnswerSum(bdCus.getAllQuestionSum() - evalResultService.queryTotal2(evalMap));


				basicDataCusList.add(bdCus);
			}
			return basicDataCusList;
		}

		return null;
	}


	/**
	 * 根据父id得到儿子
	 */
	@RequestMapping("/list2/getchild/{parentId}/leavel/{leavel}")
	@AuthIgnore
	public List<BasicDataEntityCus> list2(@PathVariable("parentId") int parentId, @PathVariable("leavel") int leavel){
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", parentId);
		Map<String, Object> evalMap = new HashMap<>();
		List<BasicDataEntity> basicDataList = basicDataService.queryList(map);
		List<BasicDataEntityCus> basicDataCusList = new LinkedList<>();
		for (BasicDataEntity entity : basicDataList){
			evalMap.clear();
			BasicDataEntityCus bdCus = new BasicDataEntityCus();
			BeanUtils.copyProperties(entity, bdCus);

			// 题目数量
			evalMap.put("createAdminid", getUserId());
			evalMap.put("type"+leavel, entity.getId());
			bdCus.setAllQuestionSum(evalQuestionService.queryTotal2(evalMap));
			// 已答数量
			evalMap.put("type"+leavel+"name", entity.getName());
			bdCus.setAllUnAnswerSum(bdCus.getAllQuestionSum() - evalResultService.queryTotal2(evalMap));


			basicDataCusList.add(bdCus);
		}

		return basicDataCusList;
	}


	/**
	 * 根据标识得到儿子
	 */
	@RequestMapping("/list3/{ename}")
	@AuthIgnore
	public List<BasicDataEntity> list3(@PathVariable("ename") String ename){
		return basicDataService.queryChildListByEname(ename);
	}

	/**
	 * 选择基础数据(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("pm:basicdata:select")
	public R select(){
		Map<String, Object> map = new HashMap<>();
		List<BasicDataEntity> basicDataList = basicDataService.queryList(map);

//		//添加一级数据
//		if(getUserId() == Constant.SUPER_ADMIN){
//			BasicDataEntity root = new BasicDataEntity();
//			root.setId(0L);
//			root.setName("一级数据");
//			root.setParentId(-1L);
//			basicDataList.add(root);
//		}

		return R.ok().put("basicDataList", basicDataList);
	}

	/**
	 * 上级数据Id(管理员则为0)
	 */
	@RequestMapping("/info")
	@RequiresPermissions("pm:basicdata:list")
	public R info(){
		long deptId = 0;
		return R.ok().put("deptId", deptId);
	}

	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@AuthIgnore
	public R info(@PathVariable("id") Long id){
		BasicDataEntity basicData = basicDataService.queryObject(id);
		
		return R.ok().put("basicData", basicData);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:basicdata:save")
	public R save(@RequestBody BasicDataEntity basicData){
        ValidatorUtils.validateEntity(basicData, AddGroup.class);
        basicData.setCreateTime(new Date());
        basicData.setCreateAdminid(getUserId());

        // 判断标识是否已存在
		if (basicDataService.queryBasicDataIdListByEname(basicData.getEname()).size() > 0){
			return R.error("标识名重复，请重新输入");
		}

		// 深度和路径
		if (basicData.getParentId() == 0){
			basicData.setDepth(1);
			basicData.setPath("0:");
		}else{
			BasicDataEntity parent = basicDataService.queryObject(basicData.getParentId());
			basicData.setDepth(parent.getDepth()+1);
			basicData.setPath(parent.getPath() + parent.getId() + ":");
		}

		basicDataService.save(basicData);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:basicdata:update")
	public R update(@RequestBody BasicDataEntity basicData){
        ValidatorUtils.validateEntity(basicData, UpdateGroup.class);
		if (basicData.getParentId() == basicData.getId()){
			return R.error("自己的上级数据不能是自己");
		}

		// 判断标识是否已存在
		if (!"".equals(basicData.getEname())) {
			if (!basicDataService.queryBasicDataIdListByEname(basicData.getEname()).contains(basicData.getId())) {
				return R.error("标识名重复，请重新输入");
			}
		}

		// 深度和路径
		if (basicData.getParentId() == 0){
			basicData.setDepth(1);
			basicData.setPath("0:");
		}else{
			BasicDataEntity parent = basicDataService.queryObject(basicData.getParentId());
			basicData.setDepth(parent.getDepth()+1);
			basicData.setPath(parent.getPath() + parent.getId() + ":");
		}

		basicDataService.update(basicData);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:basicdata:delete")
	public R delete(long id){
		//判断是否有子数据
		List<Long> bdList = basicDataService.queryBasicDataIdList(id);
		if(bdList.size() > 0){
			return R.error("请先删除子数据");
		}
		basicDataService.delete(id);
		
		return R.ok();
	}
	
}
