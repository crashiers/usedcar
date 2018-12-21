package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.InformSceneEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.InformSceneService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;


/**
 * 通知平台-通知场景
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-07-27 11:02:26
 */
@RestController
@RequestMapping("/pm/informscene")
public class InformSceneController extends AbstractController {
	@Autowired
	private InformSceneService informSceneService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:informscene:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InformSceneEntity> informSceneList = informSceneService.queryList(query);
		int total = informSceneService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(informSceneList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:informscene:info")
	public R info(@PathVariable("id") Long id){
		InformSceneEntity informScene = informSceneService.queryObject(id);
		
		return R.ok().put("informScene", informScene);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:informscene:save")
	public R save(@RequestBody InformSceneEntity informScene){
        ValidatorUtils.validateEntity(informScene, AddGroup.class);
        informScene.setCreateDate(DateUtils.getTodayDate());
        informScene.setCreateErp(getUserErp());
        informScene.setCreateTime(DateUtils.getTodayDateYMDHMS());
        informScene.setCreateTimestamp(DateUtils.getTodayTime());
		informSceneService.save(informScene);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:informscene:update")
	public R update(@RequestBody InformSceneEntity informScene){
        ValidatorUtils.validateEntity(informScene, UpdateGroup.class);
		informSceneService.update(informScene);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:informscene:delete")
	public R delete(@RequestBody Long[] ids){
		informSceneService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
