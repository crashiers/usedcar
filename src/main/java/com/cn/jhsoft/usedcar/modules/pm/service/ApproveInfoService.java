package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 满意度调查 - 调查基础信息
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
public interface ApproveInfoService {
	
	ApproveInfoEntity queryObject(Long id);
	
	List<ApproveInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ApproveInfoEntity approveInfo);
	
	void update(ApproveInfoEntity approveInfo);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
