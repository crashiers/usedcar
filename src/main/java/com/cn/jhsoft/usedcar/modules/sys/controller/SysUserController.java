package com.cn.jhsoft.usedcar.modules.sys.controller;


import com.alibaba.fastjson.JSONArray;
import com.cn.jhsoft.usedcar.common.annotation.SysLog;
import com.cn.jhsoft.usedcar.common.utils.Constant;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.validator.Assert;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.sys.service.SysUserService;
import com.cn.jhsoft.usedcar.modules.sys.service.SysUserRoleService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		//只有超级管理员，才能查看所有管理员列表
		if(getUserId() != Constant.SUPER_ADMIN){
			//params.put("createUserId", getUserId());
			params.put("isSuperAdmin", 0);
		}
		
		//查询列表数据
		Query query = new Query(params);
		List<SysUserEntity> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
		return R.ok().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");

		//sha256加密
		password = new Sha256Hash(password, getUser().getSalt()).toHex();
		//sha256加密
		newPassword = new Sha256Hash(newPassword, getUser().getSalt()).toHex();
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			return R.error("原密码不正确");
		}
		
		return R.ok();
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.queryObject(userId);
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return R.ok().put("user", user);
	}

	/**
	 * 用户信息
	 */
	@RequestMapping("/infos")
	@RequiresPermissions("sys:user:info")
	public R infos(@RequestBody Long[] userIds){
	    List<String> erpLists = new ArrayList<>();
		for (Long id : userIds){
            SysUserEntity entity = sysUserService.queryObject(id);
            erpLists.add(entity.getUsername());
        }

		return R.ok().put("erps", erpLists);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		
		user.setCreateUserId(getUserId());
		sysUserService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	//@RequiresPermissions("sys:user:update")
	public R update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		
		user.setCreateUserId(getUserId());
		sysUserService.update(user);
		
		return R.ok();
	}

    /**
     * 批量设置权限分组
     */
    @SysLog("批量设置权限分组")
    @RequestMapping("/updategroup")
    @RequiresPermissions("sys:user:update")
    public R updateGroup(@RequestBody Map<String, Object> params){

        SysUserEntity sysUserEntity;
        List<Long> roleLists = new ArrayList<>();

        JSONArray roles = (JSONArray) params.get("erpRoles");
        for (Object role : roles){
            roleLists.add(Long.parseLong(role.toString()));
        }

        JSONArray erps = (JSONArray) params.get("erps");
        for (Object erp : erps){
            sysUserEntity = sysUserService.queryByUserName(erp.toString());

            //保存用户与角色关系
            if (roleLists != null && roleLists.size() > 0) {
                sysUserRoleService.saveOrUpdate(sysUserEntity.getUserId(), roleLists);
            }else{
                sysUserRoleService.delete(sysUserEntity.getUserId());
            }
        }

        return R.ok();
    }
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return R.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		
		return R.ok();
	}
}
