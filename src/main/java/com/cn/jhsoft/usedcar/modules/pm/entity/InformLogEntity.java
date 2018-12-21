package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 通知平台-邮件发送记录
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-07-27 11:02:26
 */
public class InformLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 
     */
	private Long id;

    /**
     * 通知ID
     */
	private Long informId;

    /**
     * 通知人
     */
	private String informant;

    /**
     * 主题
     */
	private String informTheme;

    /**
     * 内容
     */
	private String informContent;

    /**
     * 发送日期
     */
	private String createDate;

    /**
     * 发送时间
     */
	private String createTime;

    /**
     * 发送时间戳
     */
	private Long createTimestamp;


	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：通知ID
	 */
	public void setInformId(Long informId) {
		this.informId = informId;
	}


	/**
	 * 获取：通知ID
	 */
	public Long getInformId() {
		return informId;
	}

	/**
	 * 设置：通知人
	 */
	public void setInformant(String informant) {
		this.informant = informant;
	}


	/**
	 * 获取：通知人
	 */
	public String getInformant() {
		return informant;
	}

	/**
	 * 设置：主题
	 */
	public void setInformTheme(String informTheme) {
		this.informTheme = informTheme;
	}


	/**
	 * 获取：主题
	 */
	public String getInformTheme() {
		return informTheme;
	}

	/**
	 * 设置：内容
	 */
	public void setInformContent(String informContent) {
		this.informContent = informContent;
	}


	/**
	 * 获取：内容
	 */
	public String getInformContent() {
		return informContent;
	}

	/**
	 * 设置：发送日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	/**
	 * 获取：发送日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：发送时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	/**
	 * 获取：发送时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：发送时间戳
	 */
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}


	/**
	 * 获取：发送时间戳
	 */
	public Long getCreateTimestamp() {
		return createTimestamp;
	}

}
