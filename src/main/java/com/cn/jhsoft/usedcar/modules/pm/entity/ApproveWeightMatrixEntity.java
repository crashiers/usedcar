package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 满意度调查 - 权重矩阵
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 10:25:12
 */
public class ApproveWeightMatrixEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 
     */
	private Long id;

    /**
     * 大类别
     */
	private Integer bigCategory;

    /**
     * 小类别x
     */
	private Integer smallCategoryX;

    /**
     * 小类别y
     */
	private Integer smallCategoryY;

    /**
     * 分值
     */
	private String amount;

    /**
     * 日期
     */
	private String createDate;

    /**
     * 添加人
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
	 * 设置：大类别
	 */
	public void setBigCategory(Integer bigCategory) {
		this.bigCategory = bigCategory;
	}


	/**
	 * 获取：大类别
	 */
	public Integer getBigCategory() {
		return bigCategory;
	}

	/**
	 * 设置：小类别x
	 */
	public void setSmallCategoryX(Integer smallCategoryX) {
		this.smallCategoryX = smallCategoryX;
	}


	/**
	 * 获取：小类别x
	 */
	public Integer getSmallCategoryX() {
		return smallCategoryX;
	}

	/**
	 * 设置：小类别y
	 */
	public void setSmallCategoryY(Integer smallCategoryY) {
		this.smallCategoryY = smallCategoryY;
	}


	/**
	 * 获取：小类别y
	 */
	public Integer getSmallCategoryY() {
		return smallCategoryY;
	}

	/**
	 * 设置：分值
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}


	/**
	 * 获取：分值
	 */
	public String getAmount() {
		return amount;
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
	 * 设置：添加人
	 */
	public void setCreateAdminid(Long createAdminid) {
		this.createAdminid = createAdminid;
	}


	/**
	 * 获取：添加人
	 */
	public Long getCreateAdminid() {
		return createAdminid;
	}

	public ApproveWeightMatrixEntity(){

	}

	public ApproveWeightMatrixEntity(Integer smallCategoryX, String amount) {
		this.smallCategoryX = smallCategoryX;
		this.amount = amount;
	}
}
