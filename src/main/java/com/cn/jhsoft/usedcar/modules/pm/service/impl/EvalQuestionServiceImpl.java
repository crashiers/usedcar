package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.EvalQuestionDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalQuestionEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalQuestionService;



@Service("evalQuestionService")
public class EvalQuestionServiceImpl implements EvalQuestionService {
	@Autowired
	private EvalQuestionDao evalQuestionDao;
	
	@Override
	public EvalQuestionEntity queryObject(Long id){
		return evalQuestionDao.queryObject(id);
	}
	
	@Override
	public List<EvalQuestionEntity> queryList(Map<String, Object> map){
		return evalQuestionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return evalQuestionDao.queryTotal(map);
	}
	
	@Override
	public void save(EvalQuestionEntity evalQuestion){
		evalQuestionDao.save(evalQuestion);
	}
	
	@Override
	public void update(EvalQuestionEntity evalQuestion){
		evalQuestionDao.update(evalQuestion);
	}
	
	@Override
	public void delete(Long id){
		evalQuestionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		evalQuestionDao.deleteBatch(ids);
	}

	@Override
	public void deleteAll() {
		evalQuestionDao.deleteAll();
	}

}
