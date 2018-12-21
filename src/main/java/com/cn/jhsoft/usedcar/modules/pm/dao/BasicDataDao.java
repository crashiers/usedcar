package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.BasicDataEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 基础数据
 * 
 * @author chenyi
 * @email hn1987@126.com
 * @date 2017-08-25 11:32:27
 */
@Mapper
public interface BasicDataDao extends BaseDao<BasicDataEntity> {
    /**
     * 查询子数据ID列表
     * @param parentId  上级数据ID
     */
    List<Long> queryBasicDataIdList(Long parentId);

    /**
     * 查询子数据ID列表，根据标识
     * @param ename  标识
     */
    List<Long> queryBasicDataIdListByEname(String ename);

    BasicDataEntity queryObjectByEname(String ename);
}
