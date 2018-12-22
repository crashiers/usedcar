package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalStageEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评测批次
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
@Mapper
public interface EvalStageDao extends BaseDao<EvalStageEntity> {

    EvalStageEntity queryObjectByNum(String num);
}
