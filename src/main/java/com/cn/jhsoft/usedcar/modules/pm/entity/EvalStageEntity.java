package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 评测批次
 *
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 19:34:52
 */
public class EvalStageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 经销商ID
	 */
	private Long dealerId;

	/**
	 * 经销商名称
	 */
	private String dealerName;

	/**
	 * 批次编号
	 */
	private String stageNum;

	/**
	 * 业务规划
	 */
	private Float score1;

	/**
	 * 业务运营
	 */
	private Float score2;

	/**
	 * 业务推广
	 */
	private Float score3;

	/**
	 * 业务执行
	 */
	private Float score4;

	/**
	 * 置换流程
	 */
	private Float score5;

	/**
	 * 零售流程
	 */
	private Float score6;

	/**
	 * 管理层
	 */
	private Float score7;

	/**
	 * 运营层
	 */
	private Float score8;

	/**
	 * 执行层
	 */
	private Float score9;

	/**
	 * 提交日期
	 */
	private String createDate;

	/**
	 * 提交时间
	 */
	private String createDatetime;

	/**
	 * 答题人ID
	 */
	private Long createAdminid;

	/**
	 * 答题人
	 */
	private String createAdmin;


	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：经销商ID
	 */
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId == null ? 0L : dealerId;
	}


	/**
	 * 获取：经销商ID
	 */
	public Long getDealerId() {
		return dealerId;
	}

	/**
	 * 设置：经销商名称
	 */
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	/**
	 * 获取：经销商名称
	 */
	public String getDealerName() {
		return dealerName == null ? "" : dealerName;
	}

	/**
	 * 设置：批次编号
	 */
	public void setStageNum(String stageNum) {
		this.stageNum = stageNum;
	}


	/**
	 * 获取：批次编号
	 */
	public String getStageNum() {
		return stageNum;
	}

	/**
	 * 设置：业务规划
	 */
	public void setScore1(Float score1) {
		this.score1 = score1;
	}


	/**
	 * 获取：业务规划
	 */
	public Float getScore1() {
		return score1;
	}

	/**
	 * 设置：业务运营
	 */
	public void setScore2(Float score2) {
		this.score2 = score2;
	}


	/**
	 * 获取：业务运营
	 */
	public Float getScore2() {
		return score2;
	}

	/**
	 * 设置：业务推广
	 */
	public void setScore3(Float score3) {
		this.score3 = score3;
	}


	/**
	 * 获取：业务推广
	 */
	public Float getScore3() {
		return score3;
	}

	/**
	 * 设置：业务执行
	 */
	public void setScore4(Float score4) {
		this.score4 = score4;
	}


	/**
	 * 获取：业务执行
	 */
	public Float getScore4() {
		return score4;
	}

	/**
	 * 设置：置换流程
	 */
	public void setScore5(Float score5) {
		this.score5 = score5;
	}


	/**
	 * 获取：置换流程
	 */
	public Float getScore5() {
		return score5;
	}

	/**
	 * 设置：零售流程
	 */
	public void setScore6(Float score6) {
		this.score6 = score6;
	}


	/**
	 * 获取：零售流程
	 */
	public Float getScore6() {
		return score6;
	}

	/**
	 * 设置：管理层
	 */
	public void setScore7(Float score7) {
		this.score7 = score7;
	}


	/**
	 * 获取：管理层
	 */
	public Float getScore7() {
		return score7;
	}

	/**
	 * 设置：运营层
	 */
	public void setScore8(Float score8) {
		this.score8 = score8;
	}


	/**
	 * 获取：运营层
	 */
	public Float getScore8() {
		return score8;
	}

	/**
	 * 设置：执行层
	 */
	public void setScore9(Float score9) {
		this.score9 = score9;
	}


	/**
	 * 获取：执行层
	 */
	public Float getScore9() {
		return score9;
	}

	/**
	 * 设置：提交日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	/**
	 * 获取：提交日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：提交时间
	 */
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}


	/**
	 * 获取：提交时间
	 */
	public String getCreateDatetime() {
		return createDatetime;
	}

	/**
	 * 设置：答题人ID
	 */
	public void setCreateAdminid(Long createAdminid) {
		this.createAdminid = createAdminid;
	}


	/**
	 * 获取：答题人ID
	 */
	public Long getCreateAdminid() {
		return createAdminid;
	}

	/**
	 * 设置：答题人
	 */
	public void setCreateAdmin(String createAdmin) {
		this.createAdmin = createAdmin;
	}


	/**
	 * 获取：答题人
	 */
	public String getCreateAdmin() {
		return createAdmin;
	}

}
