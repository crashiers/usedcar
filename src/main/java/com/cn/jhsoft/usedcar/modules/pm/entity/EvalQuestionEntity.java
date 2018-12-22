package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 评测问题
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
public class EvalQuestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 编号
     */
	private Long id;

    /**
     * 序号
     */
	private Integer num;

    /**
     * 条目
     */
	private String title;

    /**
     * 满分
     */
	private Integer fullScore;

    /**
     * 评价方式
     */
	private String evaluateWay;

    /**
     * 评价方式分数百分比
     */
	private String evaluateWayScore;

    /**
     * 一级分类
     */
	private String category1;

    /**
     * 二级分类
     */
	private String category2;

    /**
     * 三级分类
     */
	private String category3;

    /**
     * 业务阶段
     */
	private String businessStage;

    /**
     * 层级
     */
	private String tier;

    /**
     * 人员能力1
     */
	private String personnelAbility1;

    /**
     * 人员能力2
     */
	private String personnelAbility2;

    /**
     * 检查内容
     */
	private String checkContent;

    /**
     * 备注
     */
	private String remark;

    /**
     * 添加日期
     */
	private String createDate;

    /**
     * 添加时间戳
     */
	private Long createTime;

    /**
     * 添加时间
     */
	private String createDatetime;

    /**
     * 发表IP
     */
	private String createdip;

    /**
     * 添加人
     */
	private Long createAdminid;

	/**
	 * 扩充字段，答案，联合查询时用
	 */
	private String answer;


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
	 * 设置：序号
	 */
	public void setNum(Integer num) {
		this.num = num;
	}


	/**
	 * 获取：序号
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 设置：条目
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * 获取：条目
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：满分
	 */
	public void setFullScore(Integer fullScore) {
		this.fullScore = fullScore;
	}


	/**
	 * 获取：满分
	 */
	public Integer getFullScore() {
		return fullScore;
	}

	/**
	 * 设置：评价方式
	 */
	public void setEvaluateWay(String evaluateWay) {
		this.evaluateWay = evaluateWay;
	}


	/**
	 * 获取：评价方式
	 */
	public String getEvaluateWay() {
		return evaluateWay;
	}

	/**
	 * 设置：评价方式分数百分比
	 */
	public void setEvaluateWayScore(String evaluateWayScore) {
		this.evaluateWayScore = evaluateWayScore;
	}


	/**
	 * 获取：评价方式分数百分比
	 */
	public String getEvaluateWayScore() {
		return evaluateWayScore;
	}

	/**
	 * 设置：一级分类
	 */
	public void setCategory1(String category1) {
		this.category1 = category1;
	}


	/**
	 * 获取：一级分类
	 */
	public String getCategory1() {
		return category1;
	}

	/**
	 * 设置：二级分类
	 */
	public void setCategory2(String category2) {
		this.category2 = category2;
	}


	/**
	 * 获取：二级分类
	 */
	public String getCategory2() {
		return category2;
	}

	/**
	 * 设置：三级分类
	 */
	public void setCategory3(String category3) {
		this.category3 = category3;
	}


	/**
	 * 获取：三级分类
	 */
	public String getCategory3() {
		return category3;
	}

	/**
	 * 设置：业务阶段
	 */
	public void setBusinessStage(String businessStage) {
		this.businessStage = businessStage;
	}


	/**
	 * 获取：业务阶段
	 */
	public String getBusinessStage() {
		return businessStage;
	}

	/**
	 * 设置：层级
	 */
	public void setTier(String tier) {
		this.tier = tier;
	}


	/**
	 * 获取：层级
	 */
	public String getTier() {
		return tier;
	}

	/**
	 * 设置：人员能力1
	 */
	public void setPersonnelAbility1(String personnelAbility1) {
		this.personnelAbility1 = personnelAbility1;
	}


	/**
	 * 获取：人员能力1
	 */
	public String getPersonnelAbility1() {
		return personnelAbility1;
	}

	/**
	 * 设置：人员能力2
	 */
	public void setPersonnelAbility2(String personnelAbility2) {
		this.personnelAbility2 = personnelAbility2;
	}


	/**
	 * 获取：人员能力2
	 */
	public String getPersonnelAbility2() {
		return personnelAbility2;
	}

	/**
	 * 设置：检查内容
	 */
	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
	}


	/**
	 * 获取：检查内容
	 */
	public String getCheckContent() {
		return checkContent;
	}

	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}


	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：添加时间戳
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	/**
	 * 获取：添加时间戳
	 */
	public Long getCreateTime() {
		return createTime;
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
	 * 设置：发表IP
	 */
	public void setCreatedip(String createdip) {
		this.createdip = createdip;
	}


	/**
	 * 获取：发表IP
	 */
	public String getCreatedip() {
		return createdip;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
