package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;

import com.cn.jhsoft.usedcar.modules.pm.entity.DealerEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DealerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalStageEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalStageService;
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
 * 评测批次
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
@RestController
@RequestMapping("/pm/evalstage")
public class EvalStageController extends AbstractController {
	@Autowired
	private EvalStageService evalStageService;
	@Autowired
	private DealerService dealerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:evalstage:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("createAdminid", getUserId());
        Query query = new Query(params);

		List<EvalStageEntity> evalStageList = evalStageService.queryList(query);
		for (EvalStageEntity entity : evalStageList){
			DealerEntity _entity = dealerService.queryObject(entity.getDealerId());
			if (_entity != null){
				entity.setDealerName(_entity.getTitle());
			}
		}
		int total = evalStageService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(evalStageList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 管理列表
	 */
	@RequestMapping("/listall")
	@RequiresPermissions("pm:evalstage:manager")
	public R listAll(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);

		List<EvalStageEntity> evalStageList = evalStageService.queryList(query);
		for (EvalStageEntity entity : evalStageList){
			DealerEntity _entity = dealerService.queryObject(entity.getDealerId());
			if (_entity != null){
				entity.setDealerName(_entity.getTitle());
			}
		}
		int total = evalStageService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(evalStageList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:evalstage:info")
	public R info(@PathVariable("id") Long id){
		EvalStageEntity evalStage = evalStageService.queryObject(id);
		
		return R.ok().put("evalStage", evalStage);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:evalstage:save")
	public R save(@RequestBody EvalStageEntity evalStage){
        ValidatorUtils.validateEntity(evalStage, AddGroup.class);
        evalStage.setCreateAdminid(getUserId());
        evalStage.setCreateDate(DateUtils.getTodayDate());
		evalStageService.save(evalStage);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:evalstage:update")
	public R update(@RequestBody EvalStageEntity evalStage){
        ValidatorUtils.validateEntity(evalStage, UpdateGroup.class);
		evalStageService.update(evalStage);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:evalstage:delete")
	public R delete(@RequestBody Long[] ids){
		evalStageService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
