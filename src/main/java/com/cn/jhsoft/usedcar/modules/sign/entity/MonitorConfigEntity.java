package com.cn.jhsoft.usedcar.modules.sign.entity;

import java.io.Serializable;


/**
 * 监控系统配置文件
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-11-28 14:55:22
 */
public class MonitorConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 编号
     */
	private Long id;

	/**
	 * dbType
	 */
	private String dbType;

    /**
     * host
     */
	private String host;

	/**
	 * port
	 */
	private int port;

    /**
     * db
     */
	private String dbName;

    /**
     * table
     */
	private String tableName;

    /**
     * where条件
     */
	private String whereStr;

    /**
     * 日期字段名称
     */
	private String dateFieldName;

    /**
     * 监控时间（如从上午12点起，12:30）
     */
	private String monitorTime;

    /**
     * 计算时间（跑什么时间段的数据）类型，1、以当天0点为起点，2、以当前时间为起点
     */
	private Integer calculateTimeType;

    /**
     * 计算开始时间，以分钟为单位，如跑前一天的数据，则是-24*60
     */
	private Integer calculateTimeStart;

    /**
     * 计算结束时间，以分钟为单位，如跑前一天的数据，则是0
     */
	private Integer calculateTimeEnd;

	/**
	 * 通知组
	 */
	private String notifierGroup;

    /**
     * 邮箱
     */
	private String notifierEmail;

    /**
     * 手机号
     */
	private String notifierMobile;

    /**
     * 微信号
     */
	private String notifierWeixin;


	/**
	 * 设置：编号
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * 获取：编号
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：dbType
	 */
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}


	/**
	 * 获取：dbType
	 */
	public String getDbType() {
		return dbType;
	}

	/**
	 * 设置：host
	 */
	public void setHost(String host) {
		this.host = host;
	}


	/**
	 * 获取：host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 设置：port
	 */
	public void setPort(int port) {
		this.port = port;
	}


	/**
	 * 获取：port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * 设置：db
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}


	/**
	 * 获取：db
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * 设置：table
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	/**
	 * 获取：table
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * 设置：where条件
	 */
	public void setWhereStr(String whereStr) {
		this.whereStr = whereStr;
	}


	/**
	 * 获取：where条件
	 */
	public String getWhereStr() {
		return (whereStr == null || "null".equals(whereStr)) ? "" : whereStr;
	}

	/**
	 * 设置：日期字段名称
	 */
	public void setDateFieldName(String dateFieldName) {
		this.dateFieldName = dateFieldName;
	}


	/**
	 * 获取：日期字段名称
	 */
	public String getDateFieldName() {
		return dateFieldName;
	}

	/**
	 * 设置：监控时间（如从上午12点起，12:30）
	 */
	public void setMonitorTime(String monitorTime) {
		this.monitorTime = monitorTime;
	}


	/**
	 * 获取：监控时间（如从上午12点起，12:30）
	 */
	public String getMonitorTime() {
		return monitorTime;
	}

	/**
	 * 设置：计算时间（跑什么时间段的数据）类型，1、以当天0点为起点，2、以当前时间为起点
	 */
	public void setCalculateTimeType(Integer calculateTimeType) {
		this.calculateTimeType = calculateTimeType;
	}


	/**
	 * 获取：计算时间（跑什么时间段的数据）类型，1、以当天0点为起点，2、以当前时间为起点
	 */
	public Integer getCalculateTimeType() {
		return calculateTimeType;
	}

	/**
	 * 设置：计算开始时间，以分钟为单位，如跑前一天的数据，则是-24*60
	 */
	public void setCalculateTimeStart(Integer calculateTimeStart) {
		this.calculateTimeStart = calculateTimeStart;
	}


	/**
	 * 获取：计算开始时间，以分钟为单位，如跑前一天的数据，则是-24*60
	 */
	public Integer getCalculateTimeStart() {
		return calculateTimeStart;
	}

	/**
	 * 设置：计算结束时间，以分钟为单位，如跑前一天的数据，则是0
	 */
	public void setCalculateTimeEnd(Integer calculateTimeEnd) {
		this.calculateTimeEnd = calculateTimeEnd;
	}


	/**
	 * 获取：计算结束时间，以分钟为单位，如跑前一天的数据，则是0
	 */
	public Integer getCalculateTimeEnd() {
		return calculateTimeEnd;
	}

	/**
	 * 设置：通知组
	 */
	public void setNotifierGroup(String notifierGroup) {
		this.notifierGroup = notifierGroup;
	}


	/**
	 * 获取：通知组
	 */
	public String getNotifierGroup() {
		return notifierGroup;
	}

	/**
	 * 设置：邮箱
	 */
	public void setNotifierEmail(String notifierEmail) {
		this.notifierEmail = notifierEmail;
	}


	/**
	 * 获取：邮箱
	 */
	public String getNotifierEmail() {
		return notifierEmail;
	}

	/**
	 * 设置：手机号
	 */
	public void setNotifierMobile(String notifierMobile) {
		this.notifierMobile = notifierMobile;
	}


	/**
	 * 获取：手机号
	 */
	public String getNotifierMobile() {
		return notifierMobile;
	}

	/**
	 * 设置：微信号
	 */
	public void setNotifierWeixin(String notifierWeixin) {
		this.notifierWeixin = notifierWeixin;
	}


	/**
	 * 获取：微信号
	 */
	public String getNotifierWeixin() {
		return notifierWeixin;
	}

}
