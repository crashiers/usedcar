package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.DrpDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.DrpEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DrpService;



@Service("drpService")
public class DrpServiceImpl implements DrpService {
	@Autowired
	private DrpDao drpDao;
	
	@Override
	public DrpEntity queryObject(Long id){
		return drpDao.queryObject(id);
	}
	
	@Override
	public List<DrpEntity> queryList(Map<String, Object> map){
		return drpDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return drpDao.queryTotal(map);
	}
	
	@Override
	public void save(DrpEntity drp){
		drpDao.save(drp);
	}
	
	@Override
	public void update(DrpEntity drp){
		drpDao.update(drp);
	}
	
	@Override
	public void delete(Long id){
		drpDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		drpDao.deleteBatch(ids);
	}
	
}
