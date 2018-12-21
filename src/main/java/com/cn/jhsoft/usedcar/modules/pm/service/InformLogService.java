package com.cn.jhsoft.usedcar.modules.pm.service;

import com.cn.jhsoft.usedcar.modules.pm.entity.InformLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 通知平台-邮件发送记录
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-07-27 11:02:26
 */
public interface InformLogService {
	
	InformLogEntity queryObject(Long id);
	
	List<InformLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InformLogEntity informLog);
	
	void update(InformLogEntity informLog);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
