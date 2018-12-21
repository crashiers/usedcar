package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalStageEntity;

import java.util.List;
import java.util.Map;

/**
 * 评测批次
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
public interface EvalStageService {
	
	EvalStageEntity queryObject(Long id);
	
	List<EvalStageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EvalStageEntity evalStage);
	
	void update(EvalStageEntity evalStage);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
