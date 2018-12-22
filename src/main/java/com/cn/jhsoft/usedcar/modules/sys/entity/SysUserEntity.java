package com.cn.jhsoft.usedcar.modules.sys.entity;

import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2016年9月18日 上午9:28:55
 */
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户状态，1正常 0锁定
	 */
	public static final Integer STATUS_NONAR = 1;
	public static final Integer STATUS_BLOCK = 0;
	public static final Integer STATUS_PARTIAL = 2;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	@NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String username;

	/**
	 * 密码
	 */
	@JSONField(serialize = false)
	//@NotBlank(message="密码不能为空", groups = AddGroup.class)
	private String password;

	/**
	 * 盐
	 */
	@JSONField(serialize = false)   //这是不在json中返回
	private String salt;

	/**
	 * 邮箱
	 */
	//@NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
	//@Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
	//@Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message="手机号格式不正确")
	//@Length(max=6, min=3, message="{username.length}")
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	
	/**
	 * 角色ID列表
	 */
	private List<Long> roleIdList = new ArrayList<>();
	
	/**
	 * 创建者ID
	 */
	private Long createUserId;

	/**
	 * 部门ID
	 */
	//@NotNull(message="部门不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Long deptId;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 真实姓名
	 */
	private String relname;

	/**
	 * 员工号
	 */
	private String personId;

	/**
	 * 用户类型，1员工，2客户
	 */
	private String userType;

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
	 * 公司名
	 */
	private String company;

	/**
	 * 联系电话
	 */
	private String tel;

	/**
	 * 添加日期
	 */
	private String createDate;

	/**
	 * 添加时间
	 */
	private String createDatetime;

	/**
	 * 有效期至
	 */
	private String endDate;

	/**
	 * 使用次数
	 */
	private Integer usedNum;

	/**
	 * 设置：
	 * @param userId 
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * 设置：用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取：用户名
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置：密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取：密码
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置：邮箱
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：邮箱
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置：手机号
	 * @param mobile 手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取：手机号
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置：状态  0：禁用   1：正常
	 * @param status 状态  0：禁用   1：正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态  0：禁用   1：正常
	 * @return Integer
	 */
	public Integer getStatus() {
		return status;
	}

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime == null ? new Date() : createTime;
	}

	/**
	 * 设置：真实姓名
	 */
	public void setRelname(String relname) {
		this.relname = relname;
	}


	/**
	 * 获取：真实姓名
	 */
	public String getRelname() {
		return relname;
	}

	/**
	 * 设置：员工号
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}


	/**
	 * 获取：员工号
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * 设置：用户类型，1员工，2客户
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}


	/**
	 * 获取：用户类型，1员工，2客户
	 */
	public String getUserType() {
		return userType;
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
		return address;
	}

	/**
	 * 设置：公司名
	 */
	public void setCompany(String company) {
		this.company = company;
	}


	/**
	 * 获取：公司名
	 */
	public String getCompany() {
		return company == null ? "" : company;
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

	/**
	 * 设置：有效期至
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	/**
	 * 获取：有效期至
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * 设置：使用次数
	 */
	public void setUsedNum(Integer usedNum) {
		this.usedNum = usedNum;
	}


	/**
	 * 获取：使用次数
	 */
	public Integer getUsedNum() {
		return usedNum;
	}
}
