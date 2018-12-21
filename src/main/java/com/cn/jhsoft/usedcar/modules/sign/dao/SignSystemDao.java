package com.cn.jhsoft.usedcar.modules.sign.dao;

import com.cn.jhsoft.usedcar.modules.sign.entity.SignSystemEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 标签系统
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-11-14 14:31:29
 */
@Mapper
public interface SignSystemDao extends BaseDao<SignSystemEntity> {


    List<Object> queryObjectList(Map<String, Object> map);

}
