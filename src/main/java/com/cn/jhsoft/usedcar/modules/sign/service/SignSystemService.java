package com.cn.jhsoft.usedcar.modules.sign.service;

import com.cn.jhsoft.usedcar.modules.sign.entity.SignSystemEntity;

import java.util.List;
import java.util.Map;

/**
 * 标签系统
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-11-14 14:31:29
 */
public interface SignSystemService {
	
	SignSystemEntity queryObject(Long id);
	
	List<SignSystemEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SignSystemEntity signSystem);
	
	void update(SignSystemEntity signSystem);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<Object> queryObjectList(Map<String, Object> map);
}
