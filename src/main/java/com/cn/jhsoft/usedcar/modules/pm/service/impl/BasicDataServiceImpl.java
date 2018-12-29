package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import com.cn.jhsoft.usedcar.modules.pm.dao.BasicDataDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.BasicDataEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.BasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("basicDataService")
public class BasicDataServiceImpl implements BasicDataService {
	@Autowired
	private BasicDataDao basicDataDao;
	
	@Override
	public BasicDataEntity queryObject(Long id){
		return basicDataDao.queryObject(id);
	}
	
	@Override
	public List<BasicDataEntity> queryList(Map<String, Object> map){
		return basicDataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return basicDataDao.queryTotal(map);
	}
	
	@Override
	public void save(BasicDataEntity basicData){
		basicDataDao.save(basicData);
	}
	
	@Override
	public void update(BasicDataEntity basicData){
		basicDataDao.update(basicData);
	}
	
	@Override
	public void delete(Long id){
		basicDataDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		basicDataDao.deleteBatch(ids);
	}

	@Override
	public List<Long> queryBasicDataIdList(Long parentId) {
		return basicDataDao.queryBasicDataIdList(parentId);
	}

	@Override
	public List<Long> queryBasicDataIdListByEname(String ename) {
		return basicDataDao.queryBasicDataIdListByEname(ename);
	}

	@Override
	public BasicDataEntity queryObjectByEname(String ename) {
		return basicDataDao.queryObjectByEname(ename);
	}

	@Override
	public BasicDataEntity queryObjectByName(String name) {
		return basicDataDao.queryObjectByName(name);
	}

	@Override
	public BasicDataEntity queryObjectByNameAndParentId(Map<String, Object> map) {
		return basicDataDao.queryObjectByNameAndParentId(map);
	}

	@Override
	public List<BasicDataEntity> queryChildListByEname(String ename) {
		return basicDataDao.queryChildListByEname(ename);
	}

}
