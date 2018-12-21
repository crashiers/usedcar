package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalResultEntity;

import java.util.List;
import java.util.Map;

/**
 * 评测结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
public interface EvalResultService {
	
	EvalResultEntity queryObject(Long id);
	
	List<EvalResultEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EvalResultEntity evalResult);
	
	void update(EvalResultEntity evalResult);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
