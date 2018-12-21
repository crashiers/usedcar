package com.cn.jhsoft.usedcar.modules.sign.entity;

import java.io.Serializable;


/**
 * 标签系统
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-11-15 16:25:44
 */
public class SignSystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 数据编号
     */
	private Long id;

    /**
     * 用户编号
     */
	private Long customerId;

    /**
     * 客户名称
     */
	private String companyName;

    /**
     * 行业
     */
	private String industry;

    /**
     * 城市
     */
	private String city;

    /**
     * pin
     */
	private String pin;

    /**
     * 客户来源
     */
	private String utmSource;

    /**
     * serious-customer-服务线
     */
	private String isCustomer;

    /**
     * serious-workloads-服务线
     */
	private String isWorkloads;

    /**
     * 部署业务简介-服务线
     */
	private String businessDeploy;

    /**
     * 是否需要技术服务-服务线
     */
	private String isTechservice;

    /**
     * 是否有稳定性要求-服务线
     */
	private String isStability;

    /**
     * 是否有安全性要求-服务线
     */
	private String isSecurity;

    /**
     * happyCustomers-服务线
     */
	private String isHappyCustomers;

    /**
     * vip-服务线
     */
	private String isVip;

    /**
     * vvip-服务线
     */
	private String isVvip;

    /**
     * 客户接口人接触级别-服务线
     */
	private String contactLevel;

    /**
     * 客户接口人渗透级别-服务线
     */
	private String seepLevel;

    /**
     * 是否上市-服务线
     */
	private String isListed;

    /**
     * 是否有京东投资-服务线
     */
	private String isInvested;

    /**
     * 注册资金（万元）-服务线
     */
	private String registeCapital;

    /**
     * 年IT花费（万元）-服务线
     */
	private String yearSpend;

    /**
     * 其他云/IDC使用情况-服务线
     */
	private String usingDetail;

    /**
     * Lighthouse-企业线
     */
	private String isLighthouse;

    /**
     * 内部客户-企业线
     */
	private String isInnerCustomer;

    /**
     * 自营产品-企业线
     */
	private String isSelfProducts;

    /**
     * Matrix-生态线
     */
	private String isMatrix;

    /**
     * 生态线-Plus-生态线
     */
	private String isPlus;

    /**
     * 内部赋能-生态线
     */
	private String isInnerEmpowerment;

    /**
     * 云鼎-生态线
     */
	private String isCloudTripod;

    /**
     * 审核期-服务阶段
     */
	private String reviewPeriod;

    /**
     * 试运行-服务阶段
     */
	private String isTrial;

    /**
     * 正式大客户-服务阶段
     */
	private String isFormal;

    /**
     * 拟退出-服务阶段
     */
	private String isQuit;

    /**
     * 是否转入通用线
     */
	private String isGeneral;

    /**
     * 转入原因
     */
	private String reason;

    /**
     * 主架构师
     */
	private String mainArchitect;

    /**
     * 备架构师
     */
	private String bakArchitect;

    /**
     * 销售
     */
	private String sale;

    /**
     * 售前
     */
	private String preSale;

    /**
     * 架构图
     */
	private String isPicture;

    /**
     * 销售阶段-划分维度
     */
	private String saleStage;

    /**
     * 使用产品线-划分维度
     */
	private String productCode;

    /**
     * IAAS-资源清单
     */
	private String isIaas;

    /**
     * LB-资源清单
     */
	private String isLb;

    /**
     * CDN-资源清单
     */
	private String isCdn;

    /**
     * IDC-资源清单
     */
	private String isIdc;

    /**
     * 云数据库-PAAS-资源清单
     */
	private String isDb;

    /**
     * 云缓存-PAAS-资源清单
     */
	private String isRedis;

    /**
     * 云存储-PAAS-资源清单
     */
	private String isStorage;

    /**
     * 电商云saas
     */
	private String isSaas;

    /**
     * 数据云saas
     */
	private String isDataSaas;

    /**
     * 第三方saas
     */
	private String isOtherSaas;

    /**
     * 集团saas
     */
	private String isGroupSaas;

    /**
     * 华北-北京是否使用
     */
	private String isNorthBjUsing;

    /**
     * 华北-北京是否多AZ
     */
	private String isNorthBjAz;

    /**
     * 华东-上海是否使用
     */
	private String isEastShUsing;

    /**
     * 华东-上海是否多AZ
     */
	private String isEastShAz;

    /**
     * 华东-宿迁是否使用
     */
	private String isEastSqUsing;

    /**
     * 华东-宿迁是否多AZ
     */
	private String isEastSqAz;

    /**
     * 华南-广州是否使用
     */
	private String isSouthGzUsing;

    /**
     * 华南-广州是否多AZ
     */
	private String isSouthGzAz;

    /**
     * 没用云数据库&&没用云存储
     */
	private String isNodbNostorage;

    /**
     * 没有多AZ
     */
	private String isNoaz;

    /**
     * 没有LB
     */
	private String isNolb;

    /**
     * 是否有单点
     */
	private String isSingle;

    /**
     * 是否多活
     */
	private String isDouble;

    /**
     * 是否有灾备
     */
	private String isBackup;


	/**
	 * 设置：数据编号
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * 获取：数据编号
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：用户编号
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	/**
	 * 获取：用户编号
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * 设置：客户名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	/**
	 * 获取：客户名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置：行业
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}


	/**
	 * 获取：行业
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置：pin
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}


	/**
	 * 获取：pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * 设置：客户来源
	 */
	public void setUtmSource(String utmSource) {
		this.utmSource = utmSource;
	}


	/**
	 * 获取：客户来源
	 */
	public String getUtmSource() {
		return utmSource;
	}

	/**
	 * 设置：serious-customer-服务线
	 */
	public void setIsCustomer(String isCustomer) {
		this.isCustomer = isCustomer;
	}


	/**
	 * 获取：serious-customer-服务线
	 */
	public String getIsCustomer() {
		return isCustomer;
	}

	/**
	 * 设置：serious-workloads-服务线
	 */
	public void setIsWorkloads(String isWorkloads) {
		this.isWorkloads = isWorkloads;
	}


	/**
	 * 获取：serious-workloads-服务线
	 */
	public String getIsWorkloads() {
		return isWorkloads;
	}

	/**
	 * 设置：部署业务简介-服务线
	 */
	public void setBusinessDeploy(String businessDeploy) {
		this.businessDeploy = businessDeploy;
	}


	/**
	 * 获取：部署业务简介-服务线
	 */
	public String getBusinessDeploy() {
		return businessDeploy;
	}

	/**
	 * 设置：是否需要技术服务-服务线
	 */
	public void setIsTechservice(String isTechservice) {
		this.isTechservice = isTechservice;
	}


	/**
	 * 获取：是否需要技术服务-服务线
	 */
	public String getIsTechservice() {
		return isTechservice;
	}

	/**
	 * 设置：是否有稳定性要求-服务线
	 */
	public void setIsStability(String isStability) {
		this.isStability = isStability;
	}


	/**
	 * 获取：是否有稳定性要求-服务线
	 */
	public String getIsStability() {
		return isStability;
	}

	/**
	 * 设置：是否有安全性要求-服务线
	 */
	public void setIsSecurity(String isSecurity) {
		this.isSecurity = isSecurity;
	}


	/**
	 * 获取：是否有安全性要求-服务线
	 */
	public String getIsSecurity() {
		return isSecurity;
	}

	/**
	 * 设置：happyCustomers-服务线
	 */
	public void setIsHappyCustomers(String isHappyCustomers) {
		this.isHappyCustomers = isHappyCustomers;
	}


	/**
	 * 获取：happyCustomers-服务线
	 */
	public String getIsHappyCustomers() {
		return isHappyCustomers;
	}

	/**
	 * 设置：vip-服务线
	 */
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}


	/**
	 * 获取：vip-服务线
	 */
	public String getIsVip() {
		return isVip;
	}

	/**
	 * 设置：vvip-服务线
	 */
	public void setIsVvip(String isVvip) {
		this.isVvip = isVvip;
	}


	/**
	 * 获取：vvip-服务线
	 */
	public String getIsVvip() {
		return isVvip;
	}

	/**
	 * 设置：客户接口人接触级别-服务线
	 */
	public void setContactLevel(String contactLevel) {
		this.contactLevel = contactLevel;
	}


	/**
	 * 获取：客户接口人接触级别-服务线
	 */
	public String getContactLevel() {
		return contactLevel;
	}

	/**
	 * 设置：客户接口人渗透级别-服务线
	 */
	public void setSeepLevel(String seepLevel) {
		this.seepLevel = seepLevel;
	}


	/**
	 * 获取：客户接口人渗透级别-服务线
	 */
	public String getSeepLevel() {
		return seepLevel;
	}

	/**
	 * 设置：是否上市-服务线
	 */
	public void setIsListed(String isListed) {
		this.isListed = isListed;
	}


	/**
	 * 获取：是否上市-服务线
	 */
	public String getIsListed() {
		return isListed;
	}

	/**
	 * 设置：是否有京东投资-服务线
	 */
	public void setIsInvested(String isInvested) {
		this.isInvested = isInvested;
	}


	/**
	 * 获取：是否有京东投资-服务线
	 */
	public String getIsInvested() {
		return isInvested;
	}

	/**
	 * 设置：注册资金（万元）-服务线
	 */
	public void setRegisteCapital(String registeCapital) {
		this.registeCapital = registeCapital;
	}


	/**
	 * 获取：注册资金（万元）-服务线
	 */
	public String getRegisteCapital() {
		return registeCapital;
	}

	/**
	 * 设置：年IT花费（万元）-服务线
	 */
	public void setYearSpend(String yearSpend) {
		this.yearSpend = yearSpend;
	}


	/**
	 * 获取：年IT花费（万元）-服务线
	 */
	public String getYearSpend() {
		return yearSpend;
	}

	/**
	 * 设置：其他云/IDC使用情况-服务线
	 */
	public void setUsingDetail(String usingDetail) {
		this.usingDetail = usingDetail;
	}


	/**
	 * 获取：其他云/IDC使用情况-服务线
	 */
	public String getUsingDetail() {
		return usingDetail;
	}

	/**
	 * 设置：Lighthouse-企业线
	 */
	public void setIsLighthouse(String isLighthouse) {
		this.isLighthouse = isLighthouse;
	}


	/**
	 * 获取：Lighthouse-企业线
	 */
	public String getIsLighthouse() {
		return isLighthouse;
	}

	/**
	 * 设置：内部客户-企业线
	 */
	public void setIsInnerCustomer(String isInnerCustomer) {
		this.isInnerCustomer = isInnerCustomer;
	}


	/**
	 * 获取：内部客户-企业线
	 */
	public String getIsInnerCustomer() {
		return isInnerCustomer;
	}

	/**
	 * 设置：自营产品-企业线
	 */
	public void setIsSelfProducts(String isSelfProducts) {
		this.isSelfProducts = isSelfProducts;
	}


	/**
	 * 获取：自营产品-企业线
	 */
	public String getIsSelfProducts() {
		return isSelfProducts;
	}

	/**
	 * 设置：Matrix-生态线
	 */
	public void setIsMatrix(String isMatrix) {
		this.isMatrix = isMatrix;
	}


	/**
	 * 获取：Matrix-生态线
	 */
	public String getIsMatrix() {
		return isMatrix;
	}

	/**
	 * 设置：生态线-Plus-生态线
	 */
	public void setIsPlus(String isPlus) {
		this.isPlus = isPlus;
	}


	/**
	 * 获取：生态线-Plus-生态线
	 */
	public String getIsPlus() {
		return isPlus;
	}

	/**
	 * 设置：内部赋能-生态线
	 */
	public void setIsInnerEmpowerment(String isInnerEmpowerment) {
		this.isInnerEmpowerment = isInnerEmpowerment;
	}


	/**
	 * 获取：内部赋能-生态线
	 */
	public String getIsInnerEmpowerment() {
		return isInnerEmpowerment;
	}

	/**
	 * 设置：云鼎-生态线
	 */
	public void setIsCloudTripod(String isCloudTripod) {
		this.isCloudTripod = isCloudTripod;
	}


	/**
	 * 获取：云鼎-生态线
	 */
	public String getIsCloudTripod() {
		return isCloudTripod;
	}

	/**
	 * 设置：审核期-服务阶段
	 */
	public void setReviewPeriod(String reviewPeriod) {
		this.reviewPeriod = reviewPeriod;
	}


	/**
	 * 获取：审核期-服务阶段
	 */
	public String getReviewPeriod() {
		return reviewPeriod;
	}

	/**
	 * 设置：试运行-服务阶段
	 */
	public void setIsTrial(String isTrial) {
		this.isTrial = isTrial;
	}


	/**
	 * 获取：试运行-服务阶段
	 */
	public String getIsTrial() {
		return isTrial;
	}

	/**
	 * 设置：正式大客户-服务阶段
	 */
	public void setIsFormal(String isFormal) {
		this.isFormal = isFormal;
	}


	/**
	 * 获取：正式大客户-服务阶段
	 */
	public String getIsFormal() {
		return isFormal;
	}

	/**
	 * 设置：拟退出-服务阶段
	 */
	public void setIsQuit(String isQuit) {
		this.isQuit = isQuit;
	}


	/**
	 * 获取：拟退出-服务阶段
	 */
	public String getIsQuit() {
		return isQuit;
	}

	/**
	 * 设置：是否转入通用线
	 */
	public void setIsGeneral(String isGeneral) {
		this.isGeneral = isGeneral;
	}


	/**
	 * 获取：是否转入通用线
	 */
	public String getIsGeneral() {
		return isGeneral;
	}

	/**
	 * 设置：转入原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}


	/**
	 * 获取：转入原因
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * 设置：主架构师
	 */
	public void setMainArchitect(String mainArchitect) {
		this.mainArchitect = mainArchitect;
	}


	/**
	 * 获取：主架构师
	 */
	public String getMainArchitect() {
		return mainArchitect;
	}

	/**
	 * 设置：备架构师
	 */
	public void setBakArchitect(String bakArchitect) {
		this.bakArchitect = bakArchitect;
	}


	/**
	 * 获取：备架构师
	 */
	public String getBakArchitect() {
		return bakArchitect;
	}

	/**
	 * 设置：销售
	 */
	public void setSale(String sale) {
		this.sale = sale;
	}


	/**
	 * 获取：销售
	 */
	public String getSale() {
		return sale;
	}

	/**
	 * 设置：售前
	 */
	public void setPreSale(String preSale) {
		this.preSale = preSale;
	}


	/**
	 * 获取：售前
	 */
	public String getPreSale() {
		return preSale;
	}

	/**
	 * 设置：架构图
	 */
	public void setIsPicture(String isPicture) {
		this.isPicture = isPicture;
	}


	/**
	 * 获取：架构图
	 */
	public String getIsPicture() {
		return isPicture;
	}

	/**
	 * 设置：销售阶段-划分维度
	 */
	public void setSaleStage(String saleStage) {
		this.saleStage = saleStage;
	}


	/**
	 * 获取：销售阶段-划分维度
	 */
	public String getSaleStage() {
		return saleStage;
	}

	/**
	 * 设置：使用产品线-划分维度
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	/**
	 * 获取：使用产品线-划分维度
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * 设置：IAAS-资源清单
	 */
	public void setIsIaas(String isIaas) {
		this.isIaas = isIaas;
	}


	/**
	 * 获取：IAAS-资源清单
	 */
	public String getIsIaas() {
		return isIaas;
	}

	/**
	 * 设置：LB-资源清单
	 */
	public void setIsLb(String isLb) {
		this.isLb = isLb;
	}


	/**
	 * 获取：LB-资源清单
	 */
	public String getIsLb() {
		return isLb;
	}

	/**
	 * 设置：CDN-资源清单
	 */
	public void setIsCdn(String isCdn) {
		this.isCdn = isCdn;
	}


	/**
	 * 获取：CDN-资源清单
	 */
	public String getIsCdn() {
		return isCdn;
	}

	/**
	 * 设置：IDC-资源清单
	 */
	public void setIsIdc(String isIdc) {
		this.isIdc = isIdc;
	}


	/**
	 * 获取：IDC-资源清单
	 */
	public String getIsIdc() {
		return isIdc;
	}

	/**
	 * 设置：云数据库-PAAS-资源清单
	 */
	public void setIsDb(String isDb) {
		this.isDb = isDb;
	}


	/**
	 * 获取：云数据库-PAAS-资源清单
	 */
	public String getIsDb() {
		return isDb;
	}

	/**
	 * 设置：云缓存-PAAS-资源清单
	 */
	public void setIsRedis(String isRedis) {
		this.isRedis = isRedis;
	}


	/**
	 * 获取：云缓存-PAAS-资源清单
	 */
	public String getIsRedis() {
		return isRedis;
	}

	/**
	 * 设置：云存储-PAAS-资源清单
	 */
	public void setIsStorage(String isStorage) {
		this.isStorage = isStorage;
	}


	/**
	 * 获取：云存储-PAAS-资源清单
	 */
	public String getIsStorage() {
		return isStorage;
	}

	/**
	 * 设置：电商云saas
	 */
	public void setIsSaas(String isSaas) {
		this.isSaas = isSaas;
	}


	/**
	 * 获取：电商云saas
	 */
	public String getIsSaas() {
		return isSaas;
	}

	/**
	 * 设置：数据云saas
	 */
	public void setIsDataSaas(String isDataSaas) {
		this.isDataSaas = isDataSaas;
	}


	/**
	 * 获取：数据云saas
	 */
	public String getIsDataSaas() {
		return isDataSaas;
	}

	/**
	 * 设置：第三方saas
	 */
	public void setIsOtherSaas(String isOtherSaas) {
		this.isOtherSaas = isOtherSaas;
	}


	/**
	 * 获取：第三方saas
	 */
	public String getIsOtherSaas() {
		return isOtherSaas;
	}

	/**
	 * 设置：集团saas
	 */
	public void setIsGroupSaas(String isGroupSaas) {
		this.isGroupSaas = isGroupSaas;
	}


	/**
	 * 获取：集团saas
	 */
	public String getIsGroupSaas() {
		return isGroupSaas;
	}

	/**
	 * 设置：华北-北京是否使用
	 */
	public void setIsNorthBjUsing(String isNorthBjUsing) {
		this.isNorthBjUsing = isNorthBjUsing;
	}


	/**
	 * 获取：华北-北京是否使用
	 */
	public String getIsNorthBjUsing() {
		return isNorthBjUsing;
	}

	/**
	 * 设置：华北-北京是否多AZ
	 */
	public void setIsNorthBjAz(String isNorthBjAz) {
		this.isNorthBjAz = isNorthBjAz;
	}


	/**
	 * 获取：华北-北京是否多AZ
	 */
	public String getIsNorthBjAz() {
		return isNorthBjAz;
	}

	/**
	 * 设置：华东-上海是否使用
	 */
	public void setIsEastShUsing(String isEastShUsing) {
		this.isEastShUsing = isEastShUsing;
	}


	/**
	 * 获取：华东-上海是否使用
	 */
	public String getIsEastShUsing() {
		return isEastShUsing;
	}

	/**
	 * 设置：华东-上海是否多AZ
	 */
	public void setIsEastShAz(String isEastShAz) {
		this.isEastShAz = isEastShAz;
	}


	/**
	 * 获取：华东-上海是否多AZ
	 */
	public String getIsEastShAz() {
		return isEastShAz;
	}

	/**
	 * 设置：华东-宿迁是否使用
	 */
	public void setIsEastSqUsing(String isEastSqUsing) {
		this.isEastSqUsing = isEastSqUsing;
	}


	/**
	 * 获取：华东-宿迁是否使用
	 */
	public String getIsEastSqUsing() {
		return isEastSqUsing;
	}

	/**
	 * 设置：华东-宿迁是否多AZ
	 */
	public void setIsEastSqAz(String isEastSqAz) {
		this.isEastSqAz = isEastSqAz;
	}


	/**
	 * 获取：华东-宿迁是否多AZ
	 */
	public String getIsEastSqAz() {
		return isEastSqAz;
	}

	/**
	 * 设置：华南-广州是否使用
	 */
	public void setIsSouthGzUsing(String isSouthGzUsing) {
		this.isSouthGzUsing = isSouthGzUsing;
	}


	/**
	 * 获取：华南-广州是否使用
	 */
	public String getIsSouthGzUsing() {
		return isSouthGzUsing;
	}

	/**
	 * 设置：华南-广州是否多AZ
	 */
	public void setIsSouthGzAz(String isSouthGzAz) {
		this.isSouthGzAz = isSouthGzAz;
	}


	/**
	 * 获取：华南-广州是否多AZ
	 */
	public String getIsSouthGzAz() {
		return isSouthGzAz;
	}

	/**
	 * 设置：没用云数据库&&没用云存储
	 */
	public void setIsNodbNostorage(String isNodbNostorage) {
		this.isNodbNostorage = isNodbNostorage;
	}


	/**
	 * 获取：没用云数据库&&没用云存储
	 */
	public String getIsNodbNostorage() {
		return isNodbNostorage;
	}

	/**
	 * 设置：没有多AZ
	 */
	public void setIsNoaz(String isNoaz) {
		this.isNoaz = isNoaz;
	}


	/**
	 * 获取：没有多AZ
	 */
	public String getIsNoaz() {
		return isNoaz;
	}

	/**
	 * 设置：没有LB
	 */
	public void setIsNolb(String isNolb) {
		this.isNolb = isNolb;
	}


	/**
	 * 获取：没有LB
	 */
	public String getIsNolb() {
		return isNolb;
	}

	/**
	 * 设置：是否有单点
	 */
	public void setIsSingle(String isSingle) {
		this.isSingle = isSingle;
	}


	/**
	 * 获取：是否有单点
	 */
	public String getIsSingle() {
		return isSingle;
	}

	/**
	 * 设置：是否多活
	 */
	public void setIsDouble(String isDouble) {
		this.isDouble = isDouble;
	}


	/**
	 * 获取：是否多活
	 */
	public String getIsDouble() {
		return isDouble;
	}

	/**
	 * 设置：是否有灾备
	 */
	public void setIsBackup(String isBackup) {
		this.isBackup = isBackup;
	}


	/**
	 * 获取：是否有灾备
	 */
	public String getIsBackup() {
		return isBackup;
	}

}
