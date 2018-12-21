package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveDataEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.ScoreCountEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveDataService;
import com.cn.jhsoft.usedcar.modules.pm.dao.ApproveDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("approveDataService")
public class ApproveDataServiceImpl implements ApproveDataService {
	@Autowired
	private ApproveDataDao approveDataDao;
	
	@Override
	public ApproveDataEntity queryObject(Long id){
		return approveDataDao.queryObject(id);
	}
	
	@Override
	public List<ApproveDataEntity> queryList(Map<String, Object> map){
		return approveDataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return approveDataDao.queryTotal(map);
	}
	
	@Override
	public void save(ApproveDataEntity approveData){
		approveDataDao.save(approveData);
	}
	
	@Override
	public void update(ApproveDataEntity approveData){
		approveDataDao.update(approveData);
	}
	
	@Override
	public void delete(Long id){
		approveDataDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		approveDataDao.deleteBatch(ids);
	}

	@Override
	public List<ScoreCountEntity> queryScoreCountListBySmallCategory(int smallCategory) {
		return approveDataDao.queryScoreCountListBySmallCategory(smallCategory);
	}

	@Override
	public int queryQuestionCountBySmallCategory(int smallCategory) {
		return approveDataDao.queryQuestionCountBySmallCategory(smallCategory);
	}
	
}
