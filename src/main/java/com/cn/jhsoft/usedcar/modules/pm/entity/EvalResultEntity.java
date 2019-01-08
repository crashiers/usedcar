package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 评测结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
public class EvalResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 编号
     */
	private Long id;

    /**
     * 题目编号
     */
	private Integer questionNum;

    /**
     * 答题批次ID
     */
	private Long stageId;

    /**
     * 答题批次编号
     */
	private String stageNum;

	/**
	 * 经销商ID
	 */
	private Long dealerId;

    /**
     * 答案
     */
	private String answer;

    /**
     * 满分
     */
	private Integer fullScore;

	/**
	 * 答案对应分

	 */
	private Float answerScore;

    /**
     * 得分
     */
	private Float score;

    /**
     * 答题日期
     */
	private String createDate;

    /**
     * 答题时间戳
     */
	private Long createTime;

    /**
     * 答题时间
     */
	private String createDatetime;

    /**
     * 答题IP
     */
	private String createdip;

    /**
     * 答题人ID
     */
	private Long createAdminid;


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
	 * 设置：题目编号
	 */
	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}


	/**
	 * 获取：题目编号
	 */
	public Integer getQuestionNum() {
		return questionNum;
	}

	/**
	 * 设置：答题批次ID
	 */
	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}


	/**
	 * 获取：答题批次ID
	 */
	public Long getStageId() {
		return stageId;
	}

	/**
	 * 设置：答题批次编号
	 */
	public void setStageNum(String stageNum) {
		this.stageNum = stageNum;
	}


	/**
	 * 获取：答题批次编号
	 */
	public String getStageNum() {
		return stageNum;
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
	 * 设置：答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}


	/**
	 * 获取：答案
	 */
	public String getAnswer() {
		return answer;
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
	 * 设置：得分
	 */
	public void setScore(Float score) {
		this.score = score;
	}


	/**
	 * 获取：得分
	 */
	public Float getScore() {
		return score;
	}

	/**
	 * 设置：答题日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	/**
	 * 获取：答题日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：答题时间戳
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	/**
	 * 获取：答题时间戳
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：答题时间
	 */
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}


	/**
	 * 获取：答题时间
	 */
	public String getCreateDatetime() {
		return createDatetime;
	}

	/**
	 * 设置：答题IP
	 */
	public void setCreatedip(String createdip) {
		this.createdip = createdip;
	}


	/**
	 * 获取：答题IP
	 */
	public String getCreatedip() {
		return createdip;
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

	public Float getAnswerScore() {
		return answerScore;
	}

	public void setAnswerScore(Float answerScore) {
		this.answerScore = answerScore;
	}
}
