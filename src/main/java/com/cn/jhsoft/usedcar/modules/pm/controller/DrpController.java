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

import com.cn.jhsoft.usedcar.modules.pm.entity.DrpEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DrpService;
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
 * 进销存
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:57
 */
@RestController
@RequestMapping("/pm/drp")
public class DrpController extends AbstractController {
	@Autowired
	private DrpService drpService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:drp:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DrpEntity> drpList = drpService.queryList(query);
		int total = drpService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(drpList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:drp:info")
	public R info(@PathVariable("id") Long id){
		DrpEntity drp = drpService.queryObject(id);
		
		return R.ok().put("drp", drp);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:drp:save")
	public R save(@RequestBody DrpEntity drp){
        ValidatorUtils.validateEntity(drp, AddGroup.class);
		drp.setCreateDate(DateUtils.getTodayDate());
		drp.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		drpService.save(drp);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:drp:update")
	public R update(@RequestBody DrpEntity drp){
        ValidatorUtils.validateEntity(drp, UpdateGroup.class);
		drpService.update(drp);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:drp:delete")
	public R delete(@RequestBody Long[] ids){
		drpService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
