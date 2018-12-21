package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import com.cn.jhsoft.usedcar.datasources.annotation.DataSource;
import com.cn.jhsoft.usedcar.modules.pm.dao.InformLogDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.InformLogEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.InformLogService;
import com.cn.jhsoft.usedcar.datasources.DataSourceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("informLogService")
@DataSource(name = DataSourceNames.FIVE)
public class InformLogServiceImpl implements InformLogService {
	@Autowired
	private InformLogDao informLogDao;
	
	@Override
	public InformLogEntity queryObject(Long id){
		return informLogDao.queryObject(id);
	}
	
	@Override
	public List<InformLogEntity> queryList(Map<String, Object> map){
		return informLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return informLogDao.queryTotal(map);
	}
	
	@Override
	public void save(InformLogEntity informLog){
		informLogDao.save(informLog);
	}
	
	@Override
	public void update(InformLogEntity informLog){
		informLogDao.update(informLog);
	}
	
	@Override
	public void delete(Long id){
		informLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		informLogDao.deleteBatch(ids);
	}
	
}
