package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalQuestionEntity;

import java.util.List;
import java.util.Map;

/**
 * 评测问题
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
public interface EvalQuestionService {
	
	EvalQuestionEntity queryObject(Long id);
	
	List<EvalQuestionEntity> queryList(Map<String, Object> map);

	List<EvalQuestionEntity> queryList2(Map<String, Object> map);

	int queryTotal2(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EvalQuestionEntity evalQuestion);
	
	void update(EvalQuestionEntity evalQuestion);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	void deleteAll();

	List<EvalQuestionEntity> queryScoreListGroup(Map<String, Object> map);

	List<EvalQuestionEntity> queryScoreList2Group(Map<String, Object> map);
}
