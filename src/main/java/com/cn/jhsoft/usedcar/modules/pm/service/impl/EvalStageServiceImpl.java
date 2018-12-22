package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.EvalStageDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalStageEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalStageService;



@Service("evalStageService")
public class EvalStageServiceImpl implements EvalStageService {
	@Autowired
	private EvalStageDao evalStageDao;
	
	@Override
	public EvalStageEntity queryObject(Long id){
		return evalStageDao.queryObject(id);
	}
	
	@Override
	public List<EvalStageEntity> queryList(Map<String, Object> map){
		return evalStageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return evalStageDao.queryTotal(map);
	}
	
	@Override
	public void save(EvalStageEntity evalStage){
		evalStageDao.save(evalStage);
	}
	
	@Override
	public void update(EvalStageEntity evalStage){
		evalStageDao.update(evalStage);
	}
	
	@Override
	public void delete(Long id){
		evalStageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		evalStageDao.deleteBatch(ids);
	}

	@Override
	public EvalStageEntity queryObjectByNum(String num) {
		return evalStageDao.queryObjectByNum(num);
	}

}
