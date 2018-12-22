package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalResultEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 评测结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
@Mapper
public interface EvalResultDao extends BaseDao<EvalResultEntity> {

    EvalResultEntity queryObjectByRn(Map<String, Object> map);

    int queryTotal2(Map<String, Object> map);
	
}
