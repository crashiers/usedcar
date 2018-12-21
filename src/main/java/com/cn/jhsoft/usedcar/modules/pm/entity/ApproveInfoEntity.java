package com.cn.jhsoft.usedcar.modules.pm.entity;

import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import java.io.Serializable;


/**
 * 满意度调查 - 调查基础信息
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-05-11 10:25:12
 */
public class ApproveInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 
     */
	private Long id;

    /**
     * 标题
     */
	@NotBlank(message="标题不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String title;

    /**
     * 问卷范围
     */
	@NotBlank(message="问卷范围不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String scope;

    /**
     * 发放数量
     */
	@NotBlank(message="发放数量不能为空", groups = {AddGroup.class, UpdateGroup.class})
	@DecimalMin(message = "发放数量不正确", groups = {AddGroup.class, UpdateGroup.class}, value = "1") //只能大于或等于该值
	private Integer sendAmount;

    /**
     * 发放时间
     */
	private String sendDate;

    /**
     * 收回数量
     */
	@NotBlank(message="收回数量不能为空", groups = {AddGroup.class, UpdateGroup.class})
	@DecimalMin(message = "收回数量不正确", groups = {AddGroup.class, UpdateGroup.class}, value = "1") //只能大于或等于该值
	private Integer recycleAmount;

    /**
     * 收回时间
     */
	private String recycleDate;

    /**
     * 调研发起方
     */
	private String initiator;

    /**
     * 调研执行方
     */
	private String executor;

    /**
     * 说明
     */
	private String remark;

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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：问卷范围
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}


	/**
	 * 获取：问卷范围
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * 设置：发放数量
	 */
	public void setSendAmount(Integer sendAmount) {
		this.sendAmount = sendAmount;
	}


	/**
	 * 获取：发放数量
	 */
	public Integer getSendAmount() {
		return sendAmount;
	}

	/**
	 * 设置：发放时间
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}


	/**
	 * 获取：发放时间
	 */
	public String getSendDate() {
		return sendDate;
	}

	/**
	 * 设置：收回数量
	 */
	public void setRecycleAmount(Integer recycleAmount) {
		this.recycleAmount = recycleAmount;
	}


	/**
	 * 获取：收回数量
	 */
	public Integer getRecycleAmount() {
		return recycleAmount;
	}

	/**
	 * 设置：收回时间
	 */
	public void setRecycleDate(String recycleDate) {
		this.recycleDate = recycleDate;
	}


	/**
	 * 获取：收回时间
	 */
	public String getRecycleDate() {
		return recycleDate;
	}

	/**
	 * 设置：调研发起方
	 */
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}


	/**
	 * 获取：调研发起方
	 */
	public String getInitiator() {
		return initiator;
	}

	/**
	 * 设置：调研执行方
	 */
	public void setExecutor(String executor) {
		this.executor = executor;
	}


	/**
	 * 获取：调研执行方
	 */
	public String getExecutor() {
		return executor;
	}

	/**
	 * 设置：说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}


	/**
	 * 获取：说明
	 */
	public String getRemark() {
		return remark;
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

}
