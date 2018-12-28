package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.cn.jhsoft.usedcar.common.utils.ExcelPOIUtils;
import com.cn.jhsoft.usedcar.modules.sys.entity.SysUserEntity;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalQuestionEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalQuestionService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.IPUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * 评测问题
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
@RestController
@RequestMapping("/pm/evalquestion")
public class EvalQuestionController extends AbstractController {
	@Autowired
	private EvalQuestionService evalQuestionService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions(value={"pm:evalquestion:list", "pm:evalstage:list"},logical= Logical.OR)
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		if (params.get("sidx") == null || params.get("sidx").toString().equals("")){
			params.put("sidx", "num");
			params.put("order", "asc");
		}
        Query query = new Query(params);

		List<EvalQuestionEntity> evalQuestionList = evalQuestionService.queryList(query);
		int total = evalQuestionService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(evalQuestionList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	@RequiresPermissions(value={"pm:evalquestion:list", "pm:evalstage:list"},logical= Logical.OR)
	public R list2(@RequestParam Map<String, Object> params){
		//查询列表数据
		if (params.get("sidx") == null || params.get("sidx").toString().equals("")){
			params.put("sidx", "num");
			params.put("order", "asc");
		}
		params.put("createAdminid", getUserId());
		Query query = new Query(params);

		List<EvalQuestionEntity> evalQuestionList = evalQuestionService.queryList2(query);
		int total = evalQuestionService.queryTotal2(query);

		PageUtils pageUtil = new PageUtils(evalQuestionList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:evalquestion:info")
	public R info(@PathVariable("id") Long id){
		EvalQuestionEntity evalQuestion = evalQuestionService.queryObject(id);

		return R.ok().put("evalQuestion", evalQuestion);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:evalquestion:save")
	public R save(@RequestBody EvalQuestionEntity evalQuestion){

        ValidatorUtils.validateEntity(evalQuestion, AddGroup.class);

        evalQuestion.setCreateTime(DateUtils.getTimeStamp());
        evalQuestion.setCreateAdminid(getUserId());
        evalQuestion.setCreateDate(DateUtils.getTodayDate());
        evalQuestion.setCreatedip(IPUtils.getIpAddr());
        evalQuestion.setCreateAdminid(getUserId());

		evalQuestionService.save(evalQuestion);
		
		return R.ok();
	}



	/**
	 * 上传
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("pm:evalquestion:upload")
	public R save(@RequestParam("file") MultipartFile file){

		try {

			// 先删除所有数据
			evalQuestionService.deleteAll();

			// startRowNum是从0开始，1代表忽略第0行。
			List<String[]> lists = ExcelPOIUtils.readExcel(file, 0);

			// 忽略第一行 头，i从1开始
			for(int i = 1;i<lists.size();i++){

				// 放入实体对象中
				EvalQuestionEntity entity = new EvalQuestionEntity();
				String[] datas = lists.get(i);

				int num = 0;
				entity.setNum(Integer.valueOf(datas[num++]));
				entity.setTitle(datas[num++]);
				if ("".equals(entity.getTitle())){
					continue;
				}
				entity.setFullScore(Integer.valueOf(datas[num++]));
				entity.setEvaluateWay(datas[num++]);
				entity.setEvaluateWayScore(datas[num++]);
				entity.setCategory1(datas[num++]);
				entity.setCategory2(datas[num++]);
				entity.setCategory3(datas[num++]);
				entity.setBusinessStage(datas[num++]);
				entity.setTier(datas[num++]);
				entity.setPersonnelAbility1(datas[num++]);
				entity.setPersonnelAbility2(datas[num++]);
				entity.setCheckContent(datas[num++]);
				entity.setRemark(datas[num++]);

				entity.setCreateAdminid(getUserId());
				entity.setCreateDate(DateUtils.getTodayDate());
				entity.setCreateTime(DateUtils.getTimeStamp());
				entity.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
				entity.setCreatedip(IPUtils.getIpAddr());

				evalQuestionService.save(entity);
			}
		} catch (IOException e) {
			return R.error(e.getMessage());
		}

		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:evalquestion:update")
	public R update(@RequestBody EvalQuestionEntity evalQuestion){
        ValidatorUtils.validateEntity(evalQuestion, UpdateGroup.class);
		evalQuestionService.update(evalQuestion);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:evalquestion:delete")
	public R delete(@RequestBody Long[] ids){
		evalQuestionService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
