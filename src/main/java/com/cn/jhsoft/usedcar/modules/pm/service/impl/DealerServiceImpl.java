package com.cn.jhsoft.usedcar.modules.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cn.jhsoft.usedcar.modules.pm.dao.DealerDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.DealerEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DealerService;



@Service("dealerService")
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerDao dealerDao;
	
	@Override
	public DealerEntity queryObject(Long id){
		return dealerDao.queryObject(id);
	}
	
	@Override
	public List<DealerEntity> queryList(Map<String, Object> map){
		return dealerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dealerDao.queryTotal(map);
	}
	
	@Override
	public void save(DealerEntity dealer){
		dealerDao.save(dealer);
	}
	
	@Override
	public void update(DealerEntity dealer){
		dealerDao.update(dealer);
	}
	
	@Override
	public void delete(Long id){
		dealerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		dealerDao.deleteBatch(ids);
	}
	
}
