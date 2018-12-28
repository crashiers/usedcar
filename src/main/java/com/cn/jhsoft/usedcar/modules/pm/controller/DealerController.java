package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.DealerEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DealerService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;


/**
 * 经销商
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
@RestController
@RequestMapping("/pm/dealer")
public class DealerController extends AbstractController {
	@Autowired
	private DealerService dealerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions(value = {"pm:dealer:list", "pm:dr:list"}, logical= Logical.OR)
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DealerEntity> dealerList = dealerService.queryList(query);
		int total = dealerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(dealerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:dealer:info")
	public R info(@PathVariable("id") Long id){
		DealerEntity dealer = dealerService.queryObject(id);
		
		return R.ok().put("dealer", dealer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:dealer:save")
	public R save(@RequestBody DealerEntity dealer){
        ValidatorUtils.validateEntity(dealer, AddGroup.class);
        dealer.setCreateDate(DateUtils.getTodayDate());
        dealer.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		dealerService.save(dealer);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:dealer:update")
	public R update(@RequestBody DealerEntity dealer){
        ValidatorUtils.validateEntity(dealer, UpdateGroup.class);
		dealerService.update(dealer);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:dealer:delete")
	public R delete(@RequestBody Long[] ids){
		dealerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
