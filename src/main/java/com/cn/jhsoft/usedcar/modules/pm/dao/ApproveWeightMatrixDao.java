package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveWeightMatrixEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 满意度调查 - 权重矩阵
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
@Mapper
public interface ApproveWeightMatrixDao extends BaseDao<ApproveWeightMatrixEntity> {

    ApproveWeightMatrixEntity queryObjectByCate(Map<String, Object> map);

    List<String> queryWeightListBySmallCategoryY(int smallCategoryY);
}
