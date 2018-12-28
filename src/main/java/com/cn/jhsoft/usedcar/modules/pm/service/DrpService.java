package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.DrpEntity;

import java.util.List;
import java.util.Map;

/**
 * 进销存
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:57
 */
public interface DrpService {
	
	DrpEntity queryObject(Long id);
	
	List<DrpEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DrpEntity drp);
	
	void update(DrpEntity drp);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
