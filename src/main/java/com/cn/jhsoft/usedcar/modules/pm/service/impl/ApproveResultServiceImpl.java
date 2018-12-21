package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.ApproveResultDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveResultEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveResultService;



@Service("approveResultService")
public class ApproveResultServiceImpl implements ApproveResultService {
	@Autowired
	private ApproveResultDao approveResultDao;
	
	@Override
	public ApproveResultEntity queryObject(Long id){
		return approveResultDao.queryObject(id);
	}
	
	@Override
	public List<ApproveResultEntity> queryList(Map<String, Object> map){
		return approveResultDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return approveResultDao.queryTotal(map);
	}
	
	@Override
	public void save(ApproveResultEntity approveResult){
		approveResultDao.save(approveResult);
	}
	
	@Override
	public void update(ApproveResultEntity approveResult){
		approveResultDao.update(approveResult);
	}
	
	@Override
	public void delete(Long id){
		approveResultDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		approveResultDao.deleteBatch(ids);
	}
	
}
