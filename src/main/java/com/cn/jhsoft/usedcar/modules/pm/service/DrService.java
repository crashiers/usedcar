package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.DrEntity;

import java.util.List;
import java.util.Map;

/**
 * 置换零售业务
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
public interface DrService {
	
	DrEntity queryObject(Long id);
	
	List<DrEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DrEntity dr);
	
	void update(DrEntity dr);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	DrEntity queryObjectByDealerIdAndYearMonth(Map<String, Object> map);
}
