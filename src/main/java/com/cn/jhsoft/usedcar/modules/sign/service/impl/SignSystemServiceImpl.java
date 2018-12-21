package com.cn.jhsoft.usedcar.modules.sign.service.impl;

import com.cn.jhsoft.usedcar.datasources.DataSourceNames;
import com.cn.jhsoft.usedcar.datasources.annotation.DataSource;
import com.cn.jhsoft.usedcar.modules.sign.dao.SignSystemDao;
import com.cn.jhsoft.usedcar.modules.sign.entity.SignSystemEntity;
import com.cn.jhsoft.usedcar.modules.sign.service.SignSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("signSystemService")
@DataSource(name = DataSourceNames.SIX)
public class SignSystemServiceImpl implements SignSystemService {
	@Autowired
	private SignSystemDao signSystemDao;
	
	@Override
	public SignSystemEntity queryObject(Long id){
		return signSystemDao.queryObject(id);
	}
	
	@Override
	public List<SignSystemEntity> queryList(Map<String, Object> map){
		return signSystemDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return signSystemDao.queryTotal(map);
	}
	
	@Override
	public void save(SignSystemEntity signSystem){
		signSystemDao.save(signSystem);
	}
	
	@Override
	public void update(SignSystemEntity signSystem){
		signSystemDao.update(signSystem);
	}
	
	@Override
	public void delete(Long id){
		signSystemDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		signSystemDao.deleteBatch(ids);
	}

	@Override
	public List<Object> queryObjectList(Map<String, Object> map) {
		return signSystemDao.queryObjectList(map);
	}

}
