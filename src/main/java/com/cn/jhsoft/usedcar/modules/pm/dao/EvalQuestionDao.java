package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalQuestionEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 评测问题
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
@Mapper
public interface EvalQuestionDao extends BaseDao<EvalQuestionEntity> {

    void deleteAll();

    List<EvalQuestionEntity> queryList2(Map<String, Object> map);

    int queryTotal2(Map<String, Object> map);

    List<EvalQuestionEntity> queryScoreListGroup(Map<String, Object> map);

    List<EvalQuestionEntity> queryScoreList2Group(Map<String, Object> map);

    EvalQuestionEntity queryObjectByNum(Integer num);
	
}
