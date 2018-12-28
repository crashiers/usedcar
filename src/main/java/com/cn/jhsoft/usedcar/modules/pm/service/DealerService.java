package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.DealerEntity;

import java.util.List;
import java.util.Map;

/**
 * 经销商
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
public interface DealerService {
	
	DealerEntity queryObject(Long id);
	
	List<DealerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DealerEntity dealer);
	
	void update(DealerEntity dealer);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
