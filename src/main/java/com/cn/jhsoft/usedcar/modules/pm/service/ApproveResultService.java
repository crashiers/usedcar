package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveResultEntity;

import java.util.List;
import java.util.Map;

/**
 * 满意度调查 - 调查结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
public interface ApproveResultService {
	
	ApproveResultEntity queryObject(Long id);
	
	List<ApproveResultEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ApproveResultEntity approveResult);
	
	void update(ApproveResultEntity approveResult);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
