package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.ScoreCountEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveDataEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 满意度调查 - 调查数据
 *
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 09:43:39
 */
@Mapper
public interface ApproveDataDao extends BaseDao<ApproveDataEntity> {
    /**
     * 查询小类各分数个数
     * @param smallCategory  小类别
     */
    List<ScoreCountEntity> queryScoreCountListBySmallCategory(int smallCategory);

    /**
     * 查询小类问题总数
     * @param smallCategory  小类别
     */
    int queryQuestionCountBySmallCategory(int smallCategory);
}
