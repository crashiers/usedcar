package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import com.cn.jhsoft.usedcar.modules.pm.dao.ApproveInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveInfoEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveInfoService;



@Service("approveInfoService")
public class ApproveInfoServiceImpl implements ApproveInfoService {
	@Autowired
	private ApproveInfoDao approveInfoDao;
	
	@Override
	public ApproveInfoEntity queryObject(Long id){
		return approveInfoDao.queryObject(id);
	}
	
	@Override
	public List<ApproveInfoEntity> queryList(Map<String, Object> map){
		return approveInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return approveInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(ApproveInfoEntity approveInfo){
		approveInfoDao.save(approveInfo);
	}
	
	@Override
	public void update(ApproveInfoEntity approveInfo){
		approveInfoDao.update(approveInfo);
	}
	
	@Override
	public void delete(Long id){
		approveInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		approveInfoDao.deleteBatch(ids);
	}
	
}
