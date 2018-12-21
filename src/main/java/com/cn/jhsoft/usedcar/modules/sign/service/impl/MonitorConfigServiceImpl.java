package com.cn.jhsoft.usedcar.modules.sign.service.impl;

import com.cn.jhsoft.usedcar.datasources.DataSourceNames;
import com.cn.jhsoft.usedcar.datasources.annotation.DataSource;
import com.cn.jhsoft.usedcar.modules.sign.dao.MonitorConfigDao;
import com.cn.jhsoft.usedcar.modules.sign.entity.MonitorConfigEntity;
import com.cn.jhsoft.usedcar.modules.sign.service.MonitorConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("monitorConfigService")
@DataSource(name = DataSourceNames.SIX)
public class MonitorConfigServiceImpl implements MonitorConfigService {
	@Autowired
	private MonitorConfigDao monitorConfigDao;
	
	@Override
	public MonitorConfigEntity queryObject(Long id){
		return monitorConfigDao.queryObject(id);
	}
	
	@Override
	public List<MonitorConfigEntity> queryList(Map<String, Object> map){
		return monitorConfigDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return monitorConfigDao.queryTotal(map);
	}
	
	@Override
	public void save(MonitorConfigEntity monitorConfig){
		monitorConfigDao.save(monitorConfig);
	}
	
	@Override
	public void update(MonitorConfigEntity monitorConfig){
		monitorConfigDao.update(monitorConfig);
	}
	
	@Override
	public void delete(Long id){
		monitorConfigDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		monitorConfigDao.deleteBatch(ids);
	}
	
}
