package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.DrEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 置换零售业务
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
@Mapper
public interface DrDao extends BaseDao<DrEntity> {

    DrEntity queryObjectByDealerIdAndYearMonth(Map<String, Object> map);
	
}
