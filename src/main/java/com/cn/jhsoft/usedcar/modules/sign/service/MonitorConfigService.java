package com.cn.jhsoft.usedcar.modules.sign.service;

import com.cn.jhsoft.usedcar.modules.sign.entity.MonitorConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 监控系统配置文件
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-11-28 14:55:22
 */
public interface MonitorConfigService {
	
	MonitorConfigEntity queryObject(Long id);
	
	List<MonitorConfigEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MonitorConfigEntity monitorConfig);
	
	void update(MonitorConfigEntity monitorConfig);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
