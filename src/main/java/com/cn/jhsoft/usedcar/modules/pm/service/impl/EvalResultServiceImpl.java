package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.EvalResultDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalResultEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalResultService;



@Service("evalResultService")
public class EvalResultServiceImpl implements EvalResultService {
	@Autowired
	private EvalResultDao evalResultDao;
	
	@Override
	public EvalResultEntity queryObject(Long id){
		return evalResultDao.queryObject(id);
	}
	
	@Override
	public List<EvalResultEntity> queryList(Map<String, Object> map){
		return evalResultDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return evalResultDao.queryTotal(map);
	}
	
	@Override
	public void save(EvalResultEntity evalResult){
		evalResultDao.save(evalResult);
	}
	
	@Override
	public void update(EvalResultEntity evalResult){
		evalResultDao.update(evalResult);
	}
	
	@Override
	public void delete(Long id){
		evalResultDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		evalResultDao.deleteBatch(ids);
	}
	
}
