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

import com.cn.jhsoft.usedcar.modules.pm.entity.DraEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DraService;
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
 * 置换零售量
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
@RestController
@RequestMapping("/pm/dra")
public class DraController extends AbstractController {
	@Autowired
	private DraService draService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:dra:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DraEntity> draList = draService.queryList(query);
		int total = draService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(draList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:dra:info")
	public R info(@PathVariable("id") Long id){
		DraEntity dra = draService.queryObject(id);
		
		return R.ok().put("dra", dra);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:dra:save")
	public R save(@RequestBody DraEntity dra){
        ValidatorUtils.validateEntity(dra, AddGroup.class);
		dra.setCreateDate(DateUtils.getTodayDate());
		dra.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		draService.save(dra);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:dra:update")
	public R update(@RequestBody DraEntity dra){
        ValidatorUtils.validateEntity(dra, UpdateGroup.class);
		draService.update(dra);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:dra:delete")
	public R delete(@RequestBody Long[] ids){
		draService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
