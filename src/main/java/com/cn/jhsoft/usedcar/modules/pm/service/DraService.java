package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.DraEntity;

import java.util.List;
import java.util.Map;

/**
 * 置换零售量
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
public interface DraService {
	
	DraEntity queryObject(Long id);
	
	List<DraEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DraEntity dra);
	
	void update(DraEntity dra);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	DraEntity queryObjectByArcticAndYearMonthAndAtypeAndDealerId(Map<String, Object> map);
}
