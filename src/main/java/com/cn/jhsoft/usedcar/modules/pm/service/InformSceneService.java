package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.InformSceneEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知平台-通知场景
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-07-27 11:02:26
 */
public interface InformSceneService {
	
	InformSceneEntity queryObject(Long id);
	
	List<InformSceneEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InformSceneEntity informScene);
	
	void update(InformSceneEntity informScene);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<LinkedHashMap<String, Object>> superSelect(String sql);
}
