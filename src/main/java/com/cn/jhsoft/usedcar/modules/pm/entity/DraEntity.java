package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 置换零售量
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
public class DraEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 编号
     */
	private Long id;

    /**
     * 经销商ID
     */
	private Long dealerId;

    /**
     * 年月
     */
	private String yearMonth;

    /**
     * 年
     */
	private String year;

    /**
     * 月
     */
	private String month;

    /**
     * 品牌
     */
	private String brand;

    /**
     * 车型
     */
	private String arctic;

    /**
     * 类型,1置换,2零售
     */
	private Integer atype;

    /**
     * 数量
     */
	private Integer amount;

    /**
     * 添加日期
     */
	private String createDate;

    /**
     * 添加时间
     */
	private String createDatetime;


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
	 * 设置：经销商ID
	 */
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}


	/**
	 * 获取：经销商ID
	 */
	public Long getDealerId() {
		return dealerId;
	}

	/**
	 * 设置：年月
	 */
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}


	/**
	 * 获取：年月
	 */
	public String getYearMonth() {
		return yearMonth;
	}

	/**
	 * 设置：年
	 */
	public void setYear(String year) {
		this.year = year;
	}


	/**
	 * 获取：年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 设置：月
	 */
	public void setMonth(String month) {
		this.month = month;
	}


	/**
	 * 获取：月
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 设置：品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}


	/**
	 * 获取：品牌
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * 设置：车型
	 */
	public void setArctic(String arctic) {
		this.arctic = arctic;
	}


	/**
	 * 获取：车型
	 */
	public String getArctic() {
		return arctic;
	}

	/**
	 * 设置：类型,1置换,2零售
	 */
	public void setAtype(Integer atype) {
		this.atype = atype;
	}


	/**
	 * 获取：类型,1置换,2零售
	 */
	public Integer getAtype() {
		return atype;
	}

	/**
	 * 设置：数量
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	/**
	 * 获取：数量
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * 设置：添加日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	/**
	 * 获取：添加日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：添加时间
	 */
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}


	/**
	 * 获取：添加时间
	 */
	public String getCreateDatetime() {
		return createDatetime;
	}

}
