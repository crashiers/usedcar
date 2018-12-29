package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.DraDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.DraEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DraService;



@Service("draService")
public class DraServiceImpl implements DraService {
	@Autowired
	private DraDao draDao;
	
	@Override
	public DraEntity queryObject(Long id){
		return draDao.queryObject(id);
	}
	
	@Override
	public List<DraEntity> queryList(Map<String, Object> map){
		return draDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return draDao.queryTotal(map);
	}
	
	@Override
	public void save(DraEntity dra){
		draDao.save(dra);
	}
	
	@Override
	public void update(DraEntity dra){
		draDao.update(dra);
	}
	
	@Override
	public void delete(Long id){
		draDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		draDao.deleteBatch(ids);
	}

	@Override
	public DraEntity queryObjectByArcticAndYearMonthAndAtypeAndDealerId(Map<String, Object> map) {
		return draDao.queryObjectByArcticAndYearMonthAndAtypeAndDealerId(map);
	}

	@Override
	public List<DraEntity> queryListGroupYearMonth(Map<String, Object> map) {
		return draDao.queryListGroupYearMonth(map);
	}

	@Override
	public List<DraEntity> queryListGroupArctic(Map<String, Object> map) {
		return draDao.queryListGroupArctic(map);
	}

}
