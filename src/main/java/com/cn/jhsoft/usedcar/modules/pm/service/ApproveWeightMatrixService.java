package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveWeightMatrixEntity;

import java.util.List;
import java.util.Map;

/**
 * 满意度调查 - 权重矩阵
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
public interface ApproveWeightMatrixService {
	
	ApproveWeightMatrixEntity queryObject(Long id);
	
	List<ApproveWeightMatrixEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ApproveWeightMatrixEntity approveWeightMatrix);
	
	void update(ApproveWeightMatrixEntity approveWeightMatrix);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	ApproveWeightMatrixEntity queryObjectByCate(Map<String, Object> map);

	List<String> queryWeightListBySmallCategoryY(int smallCategoryY);
}
