package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 满意度调查 - 调查结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 10:25:12
 */
public class ApproveResultEntity implements Serializable {
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
     * 满意度总分
     */
	private Float approveAmount;

    /**
     * 客户期望
     */
	private Float approveAmount1;

    /**
     * 感知质量
     */
	private Float approveAmount2;

    /**
     * 感知价值
     */
	private Float approveAmount3;

    /**
     * 客户投诉
     */
	private Float approveAmount4;

    /**
     * 客户忠诚
     */
	private Float approveAmount5;

    /**
     * 状态，1未删除 2已删除
     */
	private Integer status;

    /**
     * 日期
     */
	private String createDate;

    /**
     * 操作人
     */
	private Long createAdminid;


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
	 * 设置：满意度总分
	 */
	public void setApproveAmount(Float approveAmount) {
		this.approveAmount = approveAmount;
	}


	/**
	 * 获取：满意度总分
	 */
	public Float getApproveAmount() {
		return approveAmount;
	}

	/**
	 * 设置：客户期望
	 */
	public void setApproveAmount1(Float approveAmount1) {
		this.approveAmount1 = approveAmount1;
	}


	/**
	 * 获取：客户期望
	 */
	public Float getApproveAmount1() {
		return approveAmount1;
	}

	/**
	 * 设置：感知质量
	 */
	public void setApproveAmount2(Float approveAmount2) {
		this.approveAmount2 = approveAmount2;
	}


	/**
	 * 获取：感知质量
	 */
	public Float getApproveAmount2() {
		return approveAmount2;
	}

	/**
	 * 设置：感知价值
	 */
	public void setApproveAmount3(Float approveAmount3) {
		this.approveAmount3 = approveAmount3;
	}


	/**
	 * 获取：感知价值
	 */
	public Float getApproveAmount3() {
		return approveAmount3;
	}

	/**
	 * 设置：客户投诉
	 */
	public void setApproveAmount4(Float approveAmount4) {
		this.approveAmount4 = approveAmount4;
	}


	/**
	 * 获取：客户投诉
	 */
	public Float getApproveAmount4() {
		return approveAmount4;
	}

	/**
	 * 设置：客户忠诚
	 */
	public void setApproveAmount5(Float approveAmount5) {
		this.approveAmount5 = approveAmount5;
	}


	/**
	 * 获取：客户忠诚
	 */
	public Float getApproveAmount5() {
		return approveAmount5;
	}

	/**
	 * 设置：状态，1未删除 2已删除
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}


	/**
	 * 获取：状态，1未删除 2已删除
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置：日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	/**
	 * 获取：日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：操作人
	 */
	public void setCreateAdminid(Long createAdminid) {
		this.createAdminid = createAdminid;
	}


	/**
	 * 获取：操作人
	 */
	public Long getCreateAdminid() {
		return createAdminid;
	}

}
