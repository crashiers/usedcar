package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 满意度调查 - 调查数据
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-15 13:01:43
 */
public class ApproveDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 
     */
	private Long id;

    /**
     * 基础信息ID
     */
	private Long infoId;

    /**
     * 小类别
     */
	private Integer smallCategory;

    /**
     * 题号
     */
	private Integer questionId;

    /**
     * 打分
     */
	private Float amount;

    /**
     * 用户ID
     */
	private Integer userId;

    /**
     * 用户业务线
     */
	private String userBusiness;

    /**
     * 服务商
     */
	private String bmc;

    /**
     * 是否vip
     */
	private String isVip;

    /**
     * 是否vvip
     */
	private String isVvip;

    /**
     * 是否灯塔
     */
	private String isLighthouse;

    /**
     * 客户分类
     */
	private String userKind;


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
	 * 设置：基础信息ID
	 */
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}


	/**
	 * 获取：基础信息ID
	 */
	public Long getInfoId() {
		return infoId;
	}

	/**
	 * 设置：小类别
	 */
	public void setSmallCategory(Integer smallCategory) {
		this.smallCategory = smallCategory;
	}


	/**
	 * 获取：小类别
	 */
	public Integer getSmallCategory() {
		return smallCategory;
	}

	/**
	 * 设置：题号
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}


	/**
	 * 获取：题号
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * 设置：打分
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}


	/**
	 * 获取：打分
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 设置：用户业务线
	 */
	public void setUserBusiness(String userBusiness) {
		this.userBusiness = userBusiness;
	}


	/**
	 * 获取：用户业务线
	 */
	public String getUserBusiness() {
		return userBusiness;
	}

	/**
	 * 设置：服务商
	 */
	public void setBmc(String bmc) {
		this.bmc = bmc;
	}


	/**
	 * 获取：服务商
	 */
	public String getBmc() {
		return bmc;
	}

	/**
	 * 设置：是否vip
	 */
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}


	/**
	 * 获取：是否vip
	 */
	public String getIsVip() {
		return isVip;
	}

	/**
	 * 设置：是否vvip
	 */
	public void setIsVvip(String isVvip) {
		this.isVvip = isVvip;
	}


	/**
	 * 获取：是否vvip
	 */
	public String getIsVvip() {
		return isVvip;
	}

	/**
	 * 设置：是否灯塔
	 */
	public void setIsLighthouse(String isLighthouse) {
		this.isLighthouse = isLighthouse;
	}


	/**
	 * 获取：是否灯塔
	 */
	public String getIsLighthouse() {
		return isLighthouse;
	}

	/**
	 * 设置：客户分类
	 */
	public void setUserKind(String userKind) {
		this.userKind = userKind;
	}


	/**
	 * 获取：客户分类
	 */
	public String getUserKind() {
		return userKind;
	}

}
