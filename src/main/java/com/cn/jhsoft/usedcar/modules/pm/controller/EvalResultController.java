package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalResultEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalResultService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.IPUtils;



/**
 * 评测结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
@RestController
@RequestMapping("/pm/evalresult")
public class EvalResultController extends AbstractController {
	@Autowired
	private EvalResultService evalResultService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:evalresult:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EvalResultEntity> evalResultList = evalResultService.queryList(query);
		int total = evalResultService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(evalResultList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:evalresult:info")
	public R info(@PathVariable("id") Long id){
		EvalResultEntity evalResult = evalResultService.queryObject(id);
		
		return R.ok().put("evalResult", evalResult);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:evalresult:save")
	public R save(@RequestBody EvalResultEntity evalResult){
        ValidatorUtils.validateEntity(evalResult, AddGroup.class);
        evalResult.setCreateTime(DateUtils.getTimeStamp());
        evalResult.setCreateAdminid(getUserId());
        evalResult.setCreateDate(DateUtils.getTodayDate());
        evalResult.setCreatedip(IPUtils.getIpAddr());
		evalResultService.save(evalResult);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:evalresult:update")
	public R update(@RequestBody EvalResultEntity evalResult){
        ValidatorUtils.validateEntity(evalResult, UpdateGroup.class);
		evalResultService.update(evalResult);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:evalresult:delete")
	public R delete(@RequestBody Long[] ids){
		evalResultService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
