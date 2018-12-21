package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.ScoreCountEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveDataEntity;

import java.util.List;
import java.util.Map;

/**
 * 满意度调查 - 调查数据
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
public interface ApproveDataService {
	
	ApproveDataEntity queryObject(Long id);
	
	List<ApproveDataEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ApproveDataEntity approveData);
	
	void update(ApproveDataEntity approveData);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<ScoreCountEntity> queryScoreCountListBySmallCategory(int smallCategory);

	int queryQuestionCountBySmallCategory(int smallCategory);
}
