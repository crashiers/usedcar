package com.cn.jhsoft.usedcar.modules.pm.entity;

import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;



/**
 * 经销商
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
public class DealerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 编号
     */
	private Long id;

    /**
     * 名称
     */
	@NotBlank(message="经销商名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String title;

    /**
     * 省
     */
	private String province;

    /**
     * 市
     */
	private String city;

    /**
     * 区
     */
	private String district;

    /**
     * 地址
     */
	private String address;

    /**
     * 联系人
     */
	private String relname;

    /**
     * 联系电话
     */
	private String tel;

    /**
     * 邮箱
     */
	private String email;

    /**
     * 手机号
     */
	private String mobile;

    /**
     * 基盘客户量
     */
	//@DecimalMin(value="1", message="基盘客户量要为数字", groups = {AddGroup.class, UpdateGroup.class})
	//@Pattern(regexp="^[1-9]+[0-9]*", message="基盘客户量要为数字", groups = {AddGroup.class, UpdateGroup.class})
	private Long basementClientSum;

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
	 * 设置：名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * 获取：名称
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}


	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置：区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}


	/**
	 * 获取：区
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address == null ? "" : address;
	}

	/**
	 * 设置：联系人
	 */
	public void setRelname(String relname) {
		this.relname = relname;
	}


	/**
	 * 获取：联系人
	 */
	public String getRelname() {
		return relname;
	}

	/**
	 * 设置：联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


	/**
	 * 获取：联系电话
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置：基盘客户量
	 */
	public void setBasementClientSum(Long basementClientSum) {
		this.basementClientSum = basementClientSum;
	}


	/**
	 * 获取：基盘客户量
	 */
	public Long getBasementClientSum() {
		return basementClientSum;
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
