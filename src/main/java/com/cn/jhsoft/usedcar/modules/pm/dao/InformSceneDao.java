package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.InformSceneEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 通知平台-通知场景
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-07-27 11:02:26
 */
@Mapper
public interface InformSceneDao extends BaseDao<InformSceneEntity> {
    List<LinkedHashMap<String, Object>> superSelect(String sql);
}
