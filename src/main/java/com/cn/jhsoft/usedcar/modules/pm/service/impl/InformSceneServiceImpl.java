package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import com.cn.jhsoft.usedcar.datasources.annotation.DataSource;
import com.cn.jhsoft.usedcar.datasources.DataSourceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.InformSceneDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.InformSceneEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.InformSceneService;



@Service("informSceneService")
@DataSource(name = DataSourceNames.FIVE)
public class InformSceneServiceImpl implements InformSceneService {
	@Autowired
	private InformSceneDao informSceneDao;
	
	@Override
	public InformSceneEntity queryObject(Long id){
		return informSceneDao.queryObject(id);
	}
	
	@Override
	public List<InformSceneEntity> queryList(Map<String, Object> map){
		return informSceneDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return informSceneDao.queryTotal(map);
	}
	
	@Override
	public void save(InformSceneEntity informScene){
		informSceneDao.save(informScene);
	}
	
	@Override
	public void update(InformSceneEntity informScene){
		informSceneDao.update(informScene);
	}
	
	@Override
	public void delete(Long id){
		informSceneDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		informSceneDao.deleteBatch(ids);
	}

	@Override
	public List<LinkedHashMap<String, Object>> superSelect(String sql) {
		return informSceneDao.superSelect(sql);
	}

}
