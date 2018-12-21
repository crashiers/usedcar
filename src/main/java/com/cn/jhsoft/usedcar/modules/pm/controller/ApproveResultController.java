package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveResultEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveResultService;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.R;


/**
 * 满意度调查 - 调查结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
@RestController
@RequestMapping("/pm/approveresult")
public class ApproveResultController extends AbstractController {
	@Autowired
	private ApproveResultService approveResultService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:approve:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ApproveResultEntity> approveResultList = approveResultService.queryList(query);
		int total = approveResultService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(approveResultList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:approve:info")
	public R info(@PathVariable("id") Long id){
		ApproveResultEntity approveResult = approveResultService.queryObject(id);
		
		return R.ok().put("approveResult", approveResult);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:approve:save")
	public R save(@RequestBody ApproveResultEntity approveResult){
        ValidatorUtils.validateEntity(approveResult, AddGroup.class);
        approveResult.setCreateAdminid(getUserId());
        approveResult.setCreateDate(DateUtils.format(new Date(), DateUtils.DATE_PATTERN));
		approveResultService.save(approveResult);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:approve:update")
	public R update(@RequestBody ApproveResultEntity approveResult){
        ValidatorUtils.validateEntity(approveResult, UpdateGroup.class);
		approveResultService.update(approveResult);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:approve:delete")
	public R delete(@RequestBody Long[] ids){
		approveResultService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
