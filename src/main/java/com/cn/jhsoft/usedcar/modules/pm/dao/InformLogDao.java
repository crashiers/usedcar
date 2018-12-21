package com.cn.jhsoft.usedcar.modules.pm.dao;

import com.cn.jhsoft.usedcar.modules.pm.entity.InformLogEntity;
import com.cn.jhsoft.usedcar.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 通知平台-邮件发送记录
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-07-27 11:02:26
 */
@Mapper
public interface InformLogDao extends BaseDao<InformLogEntity> {
	
}
