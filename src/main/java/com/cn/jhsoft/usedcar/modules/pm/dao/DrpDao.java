package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.DrpEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 进销存
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:57
 */
@Mapper
public interface DrpDao extends BaseDao<DrpEntity> {
    void deleteAll();

    DrpEntity queryObjectByrkdhAndDealerId(Map<String, Object> map);
}
