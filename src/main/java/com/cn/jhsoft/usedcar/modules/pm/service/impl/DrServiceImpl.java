package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.DrDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.DrEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DrService;



@Service("drService")
public class DrServiceImpl implements DrService {
	@Autowired
	private DrDao drDao;
	
	@Override
	public DrEntity queryObject(Long id){
		return drDao.queryObject(id);
	}
	
	@Override
	public List<DrEntity> queryList(Map<String, Object> map){
		return drDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return drDao.queryTotal(map);
	}
	
	@Override
	public void save(DrEntity dr){
		drDao.save(dr);
	}
	
	@Override
	public void update(DrEntity dr){
		drDao.update(dr);
	}
	
	@Override
	public void delete(Long id){
		drDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		drDao.deleteBatch(ids);
	}

	@Override
	public DrEntity queryObjectByDealerIdAndYearMonth(Map<String, Object> map) {
		return drDao.queryObjectByDealerIdAndYearMonth(map);
	}


}
