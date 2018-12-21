package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import com.cn.jhsoft.usedcar.modules.pm.dao.ApproveWeightMatrixDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveWeightMatrixEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveWeightMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("approveWeightMatrixService")
public class ApproveWeightMatrixServiceImpl implements ApproveWeightMatrixService {
	@Autowired
	private ApproveWeightMatrixDao approveWeightMatrixDao;
	
	@Override
	public ApproveWeightMatrixEntity queryObject(Long id){
		return approveWeightMatrixDao.queryObject(id);
	}
	
	@Override
	public List<ApproveWeightMatrixEntity> queryList(Map<String, Object> map){
		return approveWeightMatrixDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return approveWeightMatrixDao.queryTotal(map);
	}
	
	@Override
	public void save(ApproveWeightMatrixEntity approveWeightMatrix){
		approveWeightMatrixDao.save(approveWeightMatrix);
	}
	
	@Override
	public void update(ApproveWeightMatrixEntity approveWeightMatrix){
		approveWeightMatrixDao.update(approveWeightMatrix);
	}
	
	@Override
	public void delete(Long id){
		approveWeightMatrixDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		approveWeightMatrixDao.deleteBatch(ids);
	}

	@Override
	public ApproveWeightMatrixEntity queryObjectByCate(Map<String, Object> map) {
		return approveWeightMatrixDao.queryObjectByCate(map);
	}

	@Override
	public List<String> queryWeightListBySmallCategoryY(int smallCategoryY){
		return approveWeightMatrixDao.queryWeightListBySmallCategoryY(smallCategoryY);
	}
}
