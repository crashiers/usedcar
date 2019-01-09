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
	 * 二手车业务模式,单店运营、集团运营、单店+集团、集团+单店、第三方运营、无人运营、内部承包
	 */
	private String businessMode;

	/**
	 * 二手车部门主管上级,集团二手车部、公司总经理、销售总监、增值总监、售后总监、第三方或无部门
	 */
	private String superior;

	/**
	 * 部门人数
	 */
	private String depPersons;

	/**
	 * 二手车经理,专职、兼职
	 */
	private String managerWorkway;

	/**
	 * 专职评估师人数
	 */
	private String appraiserz;

	/**
	 * 兼职评估师人数
	 */
	private String appraiserj;

	/**
	 * 专职二手车销售顾问人数
	 */
	private String sellerz;

	/**
	 * 兼职二手车销售顾问人数
	 */
	private String sellerj;

	/**
	 * 专职信息员人数
	 */
	private String messengerz;

	/**
	 * 兼职信息员人数
	 */
	private String messengerj;

	/**
	 * 专职整备技师人数
	 */
	private String preparingz;

	/**
	 * 兼职整备技师人数
	 */
	private String preparingj;

	/**
	 * 专职翻新技师人数
	 */
	private String newz;

	/**
	 * 兼职翻新技师人数
	 */
	private String newj;

	/**
	 * 专职过户专员人数
	 */
	private String assignedz;

	/**
	 * 兼职过户专员人数
	 */
	private String assignedj;

	/**
	 * 展厅销售顾问人数
	 */
	private String exhibition;

	/**
	 * IDCC专员人数
	 */
	private String idcc;

	/**
	 * 实习销售顾问人数
	 */
	private String internship;

	/**
	 * 新车销售顾问
	 */
	private String newcarSeller;

	/**
	 * 销售总监
	 */
	private String salesDirector;

	/**
	 * 评估师
	 */
	private String appraiser;

	/**
	 * 信息员
	 */
	private String messengerPerson;

	/**
	 * 过户专员
	 */
	private String transferPerson;

	/**
	 * 翻新技师
	 */
	private String renovatePerson;

	/**
	 * 整备技师
	 */
	private String hostlingPerson;

	/**
	 * 二手车销售顾问
	 */
	private String usedcarSeller;

	/**
	 * 二手车经理
	 */
	private String usedcarManager;

	/**
	 * 新车销售顾问
	 */
	private String newcarSeller2;

	/**
	 * 评估师
	 */
	private String appraiser2;

	/**
	 * 二手车销售顾问
	 */
	private String usedcarSeller2;

	/**
	 * 信息员
	 */
	private String messengerPerson2;

	/**
	 * 翻新技师
	 */
	private String renovatePerson2;

	/**
	 * 整备技师
	 */
	private String hostlingPerson2;

	/**
	 * 过户专员
	 */
	private String transferPerson2;

	/**
	 * 二手车经理
	 */
	private String usedcarManager2;

	/**
	 * 运营资金来源,专项、新车款、无资金
	 */
	private String fundSource;

	/**
	 * 运营资金额度(万)
	 */
	private String fundAmount;

	/**
	 * 销售模式,转售、批售、零售、批售+零售、零售+批售、寄售
	 */
	private String saleMode;

	/**
	 * 营销情况简述
	 */
	private String marketingRemark;

	/**
	 * 经销商特征描述（店址分析、销售和售后经营状况、二手车基础情况等）
	 */
	private String dealerFeature;

	/**
	 * 管理层意识与能力
	 */
	private String managerLayer;

	/**
	 * 运营层意识与能力（二手车总监和二手车总监）
	 */
	private String operationLayer;

	/**
	 * 二手车人员意识与能力（执行层人员）
	 */
	private String executiveLayer;

	/**
	 * 置换业务所处阶段,筹备阶段、起步阶段、提升阶段、增量阶段
	 */
	private String permuteStage;

	/**
	 * 零售业务所处阶段,零售未开展、起步阶段、提升阶段、专业阶段
	 */
	private String sellStage;

	/**
	 * 经销商核心问题
	 */
	private String question;

	/**
	 * 提升预测,可改善、难以改善
	 */
	private String forecast;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 品牌
	 */
	@NotBlank(message="请选择品牌", groups = {AddGroup.class, UpdateGroup.class})
	private String brand;

	/**
	 * 品牌名称
	 */
	private String brandname;

    /**
     * 添加日期
     */
	private String createDate;

    /**
     * 添加时间
     */
	private String createDatetime;

	/**
	 * 添加人ID
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
	 * 设置：二手车业务模式,单店运营、集团运营、单店+集团、集团+单店、第三方运营、无人运营、内部承包
	 */
	public void setBusinessMode(String businessMode) {
		this.businessMode = businessMode;
	}


	/**
	 * 获取：二手车业务模式,单店运营、集团运营、单店+集团、集团+单店、第三方运营、无人运营、内部承包
	 */
	public String getBusinessMode() {
		return businessMode;
	}

	/**
	 * 设置：二手车部门主管上级,集团二手车部、公司总经理、销售总监、增值总监、售后总监、第三方或无部门
	 */
	public void setSuperior(String superior) {
		this.superior = superior;
	}


	/**
	 * 获取：二手车部门主管上级,集团二手车部、公司总经理、销售总监、增值总监、售后总监、第三方或无部门
	 */
	public String getSuperior() {
		return superior;
	}

	/**
	 * 设置：部门人数
	 */
	public void setDepPersons(String depPersons) {
		this.depPersons = depPersons;
	}


	/**
	 * 获取：部门人数
	 */
	public String getDepPersons() {
		return depPersons;
	}

	/**
	 * 设置：二手车经理,专职、兼职
	 */
	public void setManagerWorkway(String managerWorkway) {
		this.managerWorkway = managerWorkway;
	}


	/**
	 * 获取：二手车经理,专职、兼职
	 */
	public String getManagerWorkway() {
		return managerWorkway;
	}

	/**
	 * 设置：专职评估师人数
	 */
	public void setAppraiserz(String appraiserz) {
		this.appraiserz = appraiserz;
	}


	/**
	 * 获取：专职评估师人数
	 */
	public String getAppraiserz() {
		return appraiserz;
	}

	/**
	 * 设置：兼职评估师人数
	 */
	public void setAppraiserj(String appraiserj) {
		this.appraiserj = appraiserj;
	}


	/**
	 * 获取：兼职评估师人数
	 */
	public String getAppraiserj() {
		return appraiserj;
	}

	/**
	 * 设置：专职二手车销售顾问人数
	 */
	public void setSellerz(String sellerz) {
		this.sellerz = sellerz;
	}


	/**
	 * 获取：专职二手车销售顾问人数
	 */
	public String getSellerz() {
		return sellerz;
	}

	/**
	 * 设置：兼职二手车销售顾问人数
	 */
	public void setSellerj(String sellerj) {
		this.sellerj = sellerj;
	}


	/**
	 * 获取：兼职二手车销售顾问人数
	 */
	public String getSellerj() {
		return sellerj;
	}

	/**
	 * 设置：专职信息员人数
	 */
	public void setMessengerz(String messengerz) {
		this.messengerz = messengerz;
	}


	/**
	 * 获取：专职信息员人数
	 */
	public String getMessengerz() {
		return messengerz;
	}

	/**
	 * 设置：兼职信息员人数
	 */
	public void setMessengerj(String messengerj) {
		this.messengerj = messengerj;
	}


	/**
	 * 获取：兼职信息员人数
	 */
	public String getMessengerj() {
		return messengerj;
	}

	/**
	 * 设置：专职整备技师人数
	 */
	public void setPreparingz(String preparingz) {
		this.preparingz = preparingz;
	}


	/**
	 * 获取：专职整备技师人数
	 */
	public String getPreparingz() {
		return preparingz;
	}

	/**
	 * 设置：兼职整备技师人数
	 */
	public void setPreparingj(String preparingj) {
		this.preparingj = preparingj;
	}


	/**
	 * 获取：兼职整备技师人数
	 */
	public String getPreparingj() {
		return preparingj;
	}

	/**
	 * 设置：专职翻新技师人数
	 */
	public void setNewz(String newz) {
		this.newz = newz;
	}


	/**
	 * 获取：专职翻新技师人数
	 */
	public String getNewz() {
		return newz;
	}

	/**
	 * 设置：兼职翻新技师人数
	 */
	public void setNewj(String newj) {
		this.newj = newj;
	}


	/**
	 * 获取：兼职翻新技师人数
	 */
	public String getNewj() {
		return newj;
	}

	/**
	 * 设置：专职过户专员人数
	 */
	public void setAssignedz(String assignedz) {
		this.assignedz = assignedz;
	}


	/**
	 * 获取：专职过户专员人数
	 */
	public String getAssignedz() {
		return assignedz;
	}

	/**
	 * 设置：兼职过户专员人数
	 */
	public void setAssignedj(String assignedj) {
		this.assignedj = assignedj;
	}


	/**
	 * 获取：兼职过户专员人数
	 */
	public String getAssignedj() {
		return assignedj;
	}

	/**
	 * 设置：展厅销售顾问人数
	 */
	public void setExhibition(String exhibition) {
		this.exhibition = exhibition;
	}


	/**
	 * 获取：展厅销售顾问人数
	 */
	public String getExhibition() {
		return exhibition;
	}

	/**
	 * 设置：IDCC专员人数
	 */
	public void setIdcc(String idcc) {
		this.idcc = idcc;
	}


	/**
	 * 获取：IDCC专员人数
	 */
	public String getIdcc() {
		return idcc;
	}

	/**
	 * 设置：实习销售顾问人数
	 */
	public void setInternship(String internship) {
		this.internship = internship;
	}


	/**
	 * 获取：实习销售顾问人数
	 */
	public String getInternship() {
		return internship;
	}

	/**
	 * 设置：新车销售顾问
	 */
	public void setNewcarSeller(String newcarSeller) {
		this.newcarSeller = newcarSeller;
	}


	/**
	 * 获取：新车销售顾问
	 */
	public String getNewcarSeller() {
		return newcarSeller;
	}

	/**
	 * 设置：销售总监
	 */
	public void setSalesDirector(String salesDirector) {
		this.salesDirector = salesDirector;
	}


	/**
	 * 获取：销售总监
	 */
	public String getSalesDirector() {
		return salesDirector;
	}

	/**
	 * 设置：评估师
	 */
	public void setAppraiser(String appraiser) {
		this.appraiser = appraiser;
	}


	/**
	 * 获取：评估师
	 */
	public String getAppraiser() {
		return appraiser;
	}

	/**
	 * 设置：信息员
	 */
	public void setMessengerPerson(String messengerPerson) {
		this.messengerPerson = messengerPerson;
	}


	/**
	 * 获取：信息员
	 */
	public String getMessengerPerson() {
		return messengerPerson;
	}

	/**
	 * 设置：过户专员
	 */
	public void setTransferPerson(String transferPerson) {
		this.transferPerson = transferPerson;
	}


	/**
	 * 获取：过户专员
	 */
	public String getTransferPerson() {
		return transferPerson;
	}

	/**
	 * 设置：翻新技师
	 */
	public void setRenovatePerson(String renovatePerson) {
		this.renovatePerson = renovatePerson;
	}


	/**
	 * 获取：翻新技师
	 */
	public String getRenovatePerson() {
		return renovatePerson;
	}

	/**
	 * 设置：整备技师
	 */
	public void setHostlingPerson(String hostlingPerson) {
		this.hostlingPerson = hostlingPerson;
	}


	/**
	 * 获取：整备技师
	 */
	public String getHostlingPerson() {
		return hostlingPerson;
	}

	/**
	 * 设置：二手车销售顾问
	 */
	public void setUsedcarSeller(String usedcarSeller) {
		this.usedcarSeller = usedcarSeller;
	}


	/**
	 * 获取：二手车销售顾问
	 */
	public String getUsedcarSeller() {
		return usedcarSeller;
	}

	/**
	 * 设置：二手车经理
	 */
	public void setUsedcarManager(String usedcarManager) {
		this.usedcarManager = usedcarManager;
	}


	/**
	 * 获取：二手车经理
	 */
	public String getUsedcarManager() {
		return usedcarManager;
	}

	/**
	 * 设置：新车销售顾问
	 */
	public void setNewcarSeller2(String newcarSeller2) {
		this.newcarSeller2 = newcarSeller2;
	}


	/**
	 * 获取：新车销售顾问
	 */
	public String getNewcarSeller2() {
		return newcarSeller2;
	}

	/**
	 * 设置：评估师
	 */
	public void setAppraiser2(String appraiser2) {
		this.appraiser2 = appraiser2;
	}


	/**
	 * 获取：评估师
	 */
	public String getAppraiser2() {
		return appraiser2;
	}

	/**
	 * 设置：二手车销售顾问
	 */
	public void setUsedcarSeller2(String usedcarSeller2) {
		this.usedcarSeller2 = usedcarSeller2;
	}


	/**
	 * 获取：二手车销售顾问
	 */
	public String getUsedcarSeller2() {
		return usedcarSeller2;
	}

	/**
	 * 设置：信息员
	 */
	public void setMessengerPerson2(String messengerPerson2) {
		this.messengerPerson2 = messengerPerson2;
	}


	/**
	 * 获取：信息员
	 */
	public String getMessengerPerson2() {
		return messengerPerson2;
	}

	/**
	 * 设置：翻新技师
	 */
	public void setRenovatePerson2(String renovatePerson2) {
		this.renovatePerson2 = renovatePerson2;
	}


	/**
	 * 获取：翻新技师
	 */
	public String getRenovatePerson2() {
		return renovatePerson2;
	}

	/**
	 * 设置：整备技师
	 */
	public void setHostlingPerson2(String hostlingPerson2) {
		this.hostlingPerson2 = hostlingPerson2;
	}


	/**
	 * 获取：整备技师
	 */
	public String getHostlingPerson2() {
		return hostlingPerson2;
	}

	/**
	 * 设置：过户专员
	 */
	public void setTransferPerson2(String transferPerson2) {
		this.transferPerson2 = transferPerson2;
	}


	/**
	 * 获取：过户专员
	 */
	public String getTransferPerson2() {
		return transferPerson2;
	}

	/**
	 * 设置：二手车经理
	 */
	public void setUsedcarManager2(String usedcarManager2) {
		this.usedcarManager2 = usedcarManager2;
	}


	/**
	 * 获取：二手车经理
	 */
	public String getUsedcarManager2() {
		return usedcarManager2;
	}

	/**
	 * 设置：运营资金来源,专项、新车款、无资金
	 */
	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}


	/**
	 * 获取：运营资金来源,专项、新车款、无资金
	 */
	public String getFundSource() {
		return fundSource;
	}

	/**
	 * 设置：运营资金额度(万)
	 */
	public void setFundAmount(String fundAmount) {
		this.fundAmount = fundAmount;
	}


	/**
	 * 获取：运营资金额度(万)
	 */
	public String getFundAmount() {
		return fundAmount;
	}

	/**
	 * 设置：销售模式,转售、批售、零售、批售+零售、零售+批售、寄售
	 */
	public void setSaleMode(String saleMode) {
		this.saleMode = saleMode;
	}


	/**
	 * 获取：销售模式,转售、批售、零售、批售+零售、零售+批售、寄售
	 */
	public String getSaleMode() {
		return saleMode;
	}

	/**
	 * 设置：营销情况简述
	 */
	public void setMarketingRemark(String marketingRemark) {
		this.marketingRemark = marketingRemark;
	}


	/**
	 * 获取：营销情况简述
	 */
	public String getMarketingRemark() {
		return marketingRemark;
	}

	/**
	 * 设置：经销商特征描述（店址分析、销售和售后经营状况、二手车基础情况等）
	 */
	public void setDealerFeature(String dealerFeature) {
		this.dealerFeature = dealerFeature;
	}


	/**
	 * 获取：经销商特征描述（店址分析、销售和售后经营状况、二手车基础情况等）
	 */
	public String getDealerFeature() {
		return dealerFeature;
	}

	/**
	 * 设置：管理层意识与能力
	 */
	public void setManagerLayer(String managerLayer) {
		this.managerLayer = managerLayer;
	}


	/**
	 * 获取：管理层意识与能力
	 */
	public String getManagerLayer() {
		return managerLayer;
	}

	/**
	 * 设置：运营层意识与能力（二手车总监和二手车总监）
	 */
	public void setOperationLayer(String operationLayer) {
		this.operationLayer = operationLayer;
	}


	/**
	 * 获取：运营层意识与能力（二手车总监和二手车总监）
	 */
	public String getOperationLayer() {
		return operationLayer;
	}

	/**
	 * 设置：二手车人员意识与能力（执行层人员）
	 */
	public void setExecutiveLayer(String executiveLayer) {
		this.executiveLayer = executiveLayer;
	}


	/**
	 * 获取：二手车人员意识与能力（执行层人员）
	 */
	public String getExecutiveLayer() {
		return executiveLayer;
	}

	/**
	 * 设置：置换业务所处阶段,筹备阶段、起步阶段、提升阶段、增量阶段
	 */
	public void setPermuteStage(String permuteStage) {
		this.permuteStage = permuteStage;
	}


	/**
	 * 获取：置换业务所处阶段,筹备阶段、起步阶段、提升阶段、增量阶段
	 */
	public String getPermuteStage() {
		return permuteStage;
	}

	/**
	 * 设置：零售业务所处阶段,零售未开展、起步阶段、提升阶段、专业阶段
	 */
	public void setSellStage(String sellStage) {
		this.sellStage = sellStage;
	}


	/**
	 * 获取：零售业务所处阶段,零售未开展、起步阶段、提升阶段、专业阶段
	 */
	public String getSellStage() {
		return sellStage;
	}

	/**
	 * 设置：经销商核心问题
	 */
	public void setQuestion(String question) {
		this.question = question;
	}


	/**
	 * 获取：经销商核心问题
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * 设置：提升预测,可改善、难以改善
	 */
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}


	/**
	 * 获取：提升预测,可改善、难以改善
	 */
	public String getForecast() {
		return forecast;
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
	 * 设置：品牌名称
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	/**
	 * 获取：品牌名称
	 */
	public String getBrandname() {
		return brandname;
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
	 * 设置：添加人ID
	 */
	public void setCreateAdminid(Long createAdminid) {
		this.createAdminid = createAdminid;
	}


	/**
	 * 获取：添加人ID
	 */
	public Long getCreateAdminid() {
		return createAdminid;
	}

}
