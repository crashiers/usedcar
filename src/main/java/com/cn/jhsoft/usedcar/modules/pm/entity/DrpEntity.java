package com.cn.jhsoft.usedcar.modules.pm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 进销存
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:57
 */
public class DrpEntity implements Serializable {
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
     * 序号
     */
	private Long num;

    /**
     * 入库号
     */
	private String rkdh;

    /**
     * 品牌
     */
	private String brand;

    /**
     * 车型
     */
	private String arctic;

    /**
     * 车款
     */
	private String carModel;

    /**
     * 颜色
     */
	private String color;

    /**
     * 表征里程
     */
	private String mileage;

    /**
     * 初登日期
     */
	private String firstDate;

    /**
     * 排量
     */
	private String displacement;

    /**
     * 变速箱
     */
	private String gearbox;

    /**
     * 车架号
     */
	private String vin;

    /**
     * 车况简述
     */
	private String remark;

    /**
     * 收购类型:置换收购,直客收购,渠道收购,车辆寄售,内部转入
     */
	private String buyType;

    /**
     * 收购客户来源:基盘客户挖掘,内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他
     */
	private String buyClientRef;

    /**
     * 收购单位
     */
	private String buyCompany;

    /**
     * 推荐人
     */
	private String buyReferrer;

    /**
     * 推荐人职务
     */
	private String buyReferrerDuty;

    /**
     * 收购人
     */
	private String buyer;

    /**
     * 旧车主姓名
     */
	private String rawCarOwner;

    /**
     * 联系电话
     */
	private String rawPhone;

    /**
     * 置换车型
     */
	private String permuteArctic;

    /**
     * 收购日期
     */
	private String buyDate;

    /**
     * 收购价格
     */
	private String buyPrice;

    /**
     * 过户费用
     */
	private String buyTransferFee;

    /**
     * 其他收购成本
     */
	private String buyOtherFee;

    /**
     * 预期库存风险期（盈亏平衡点）
     */
	private String bep;

    /**
     * 库位号
     */
	private String slNum;

    /**
     * 上架销售时间
     */
	private String sellDate;

    /**
     * 是否认证
     */
	private String isAuth;

    /**
     * 整备费用
     */
	private String servicingCosts;

    /**
     * 日常维护费用
     */
	private String upkeep;

    /**
     * 验车费
     */
	private String checkFee;

    /**
     * 购买交强险
     */
	private String sali;

    /**
     * 库存时间
     */
	private String storeTime;

    /**
     * 是否超期
     */
	private String isExceed;

    /**
     * 批售起竞价/零售底价
     */
	private String minPrice;

    /**
     * 批售保留价/零售定价
     */
	private String sellPrice;

    /**
     * 销售类型:内部转出,外部批售,零售,认证零售
     */
	private String sellType;

    /**
     * 销售客户来源:内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他
     */
	private String sellClientRef;

    /**
     * 推荐人
     */
	private String sellReferrer;

    /**
     * 推荐人职务
     */
	private String sellReferrerDuty;

    /**
     * 销售人
     */
	private String seller;

    /**
     * 新车主名称
     */
	private String newCarOwner;

    /**
     * 联系电话
     */
	private String newPhone;

    /**
     * 批售渠道名称（零售不需要填写）
     */
	private String channel;

    /**
     * 销售日期
     */
	private String sellDateFinal;

    /**
     * 销售价格
     */
	private String sellPriceFinal;

    /**
     * 付款方式
     */
	private String paymentType;

    /**
     * 首付金额
     */
	private String paymentFirstMoney;

    /**
     * 贷款金额
     */
	private String paymentLoanMoney;

    /**
     * 过户费用
     */
	private String transferFee;

    /**
     * 其他销售成本
     */
	private String sellOtherFee;

    /**
     * 退商业险
     */
	private String rbr;

    /**
     * 金融手续费
     */
	private String fhc;

    /**
     * 保险利润
     */
	private String profitInsurance;

    /**
     * 装饰利润
     */
	private String profitDecorative;

    /**
     * 手续代办
     */
	private String formalitieCharge;

    /**
     * 厂家返利
     */
	private String rebate;

    /**
     * 其他
     */
	private String other;

    /**
     * 进销差毛利1
     */
	private String maori;

    /**
     * 收购毛利率1
     */
	private String maoriRate;

    /**
     * 直接成本
     */
	private String directCost;

    /**
     * 毛利2
     */
	private String maori2;

    /**
     * 收购毛利率2
     */
	private String maoriRate2;

    /**
     * 衍生收益
     */
	private String otherEarnings;

    /**
     * 厂家返利
     */
	private String rebate2;

    /**
     * 综合毛利
     */
	private String synthesisMaori;

    /**
     * 收购年
     */
	private String buyYear;

    /**
     * 收购月
     */
	private String buyMonth;

    /**
     * 销售年
     */
	private String sellYear;

    /**
     * 销售月
     */
	private String sellMonth;

    /**
     * 收购方式(采购来源=1)
     */
	private String buyWay;

    /**
     * 销售方式(零售=0，认证零售=1)
     */
	private String sellWay;

    /**
     * 销售方式2
     */
	private String sellWay2;

    /**
     * 车龄
     */
	private String carAge;

    /**
     * 车龄阶梯
     */
	private String carAgeLeavel;

    /**
     * 收车价格阶梯
     */
	private String buyPriceLeavel;

    /**
     * 是否库存
     */
	private String isStore;

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
	 * 设置：序号
	 */
	public void setNum(Long num) {
		this.num = num;
	}


	/**
	 * 获取：序号
	 */
	public Long getNum() {
		return num;
	}

	/**
	 * 设置：入库号
	 */
	public void setRkdh(String rkdh) {
		this.rkdh = rkdh;
	}


	/**
	 * 获取：入库号
	 */
	public String getRkdh() {
		return rkdh;
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
	 * 设置：车款
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	/**
	 * 获取：车款
	 */
	public String getCarModel() {
		return carModel;
	}

	/**
	 * 设置：颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}


	/**
	 * 获取：颜色
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 设置：表征里程
	 */
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}


	/**
	 * 获取：表征里程
	 */
	public String getMileage() {
		return mileage;
	}

	/**
	 * 设置：初登日期
	 */
	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}


	/**
	 * 获取：初登日期
	 */
	public String getFirstDate() {
		return firstDate;
	}

	/**
	 * 设置：排量
	 */
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}


	/**
	 * 获取：排量
	 */
	public String getDisplacement() {
		return displacement;
	}

	/**
	 * 设置：变速箱
	 */
	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}


	/**
	 * 获取：变速箱
	 */
	public String getGearbox() {
		return gearbox;
	}

	/**
	 * 设置：车架号
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}


	/**
	 * 获取：车架号
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * 设置：车况简述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}


	/**
	 * 获取：车况简述
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置：收购类型:置换收购,直客收购,渠道收购,车辆寄售,内部转入
	 */
	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}


	/**
	 * 获取：收购类型:置换收购,直客收购,渠道收购,车辆寄售,内部转入
	 */
	public String getBuyType() {
		return buyType;
	}

	/**
	 * 设置：收购客户来源:基盘客户挖掘,内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他
	 */
	public void setBuyClientRef(String buyClientRef) {
		this.buyClientRef = buyClientRef;
	}


	/**
	 * 获取：收购客户来源:基盘客户挖掘,内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他
	 */
	public String getBuyClientRef() {
		return buyClientRef;
	}

	/**
	 * 设置：收购单位
	 */
	public void setBuyCompany(String buyCompany) {
		this.buyCompany = buyCompany;
	}


	/**
	 * 获取：收购单位
	 */
	public String getBuyCompany() {
		return buyCompany;
	}

	/**
	 * 设置：推荐人
	 */
	public void setBuyReferrer(String buyReferrer) {
		this.buyReferrer = buyReferrer;
	}


	/**
	 * 获取：推荐人
	 */
	public String getBuyReferrer() {
		return buyReferrer;
	}

	/**
	 * 设置：推荐人职务
	 */
	public void setBuyReferrerDuty(String buyReferrerDuty) {
		this.buyReferrerDuty = buyReferrerDuty;
	}


	/**
	 * 获取：推荐人职务
	 */
	public String getBuyReferrerDuty() {
		return buyReferrerDuty;
	}

	/**
	 * 设置：收购人
	 */
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}


	/**
	 * 获取：收购人
	 */
	public String getBuyer() {
		return buyer;
	}

	/**
	 * 设置：旧车主姓名
	 */
	public void setRawCarOwner(String rawCarOwner) {
		this.rawCarOwner = rawCarOwner;
	}


	/**
	 * 获取：旧车主姓名
	 */
	public String getRawCarOwner() {
		return rawCarOwner;
	}

	/**
	 * 设置：联系电话
	 */
	public void setRawPhone(String rawPhone) {
		this.rawPhone = rawPhone;
	}


	/**
	 * 获取：联系电话
	 */
	public String getRawPhone() {
		return rawPhone;
	}

	/**
	 * 设置：置换车型
	 */
	public void setPermuteArctic(String permuteArctic) {
		this.permuteArctic = permuteArctic;
	}


	/**
	 * 获取：置换车型
	 */
	public String getPermuteArctic() {
		return permuteArctic;
	}

	/**
	 * 设置：收购日期
	 */
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}


	/**
	 * 获取：收购日期
	 */
	public String getBuyDate() {
		return buyDate;
	}

	/**
	 * 设置：收购价格
	 */
	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}


	/**
	 * 获取：收购价格
	 */
	public String getBuyPrice() {
		return buyPrice;
	}

	/**
	 * 设置：过户费用
	 */
	public void setBuyTransferFee(String buyTransferFee) {
		this.buyTransferFee = buyTransferFee;
	}


	/**
	 * 获取：过户费用
	 */
	public String getBuyTransferFee() {
		return buyTransferFee;
	}

	/**
	 * 设置：其他收购成本
	 */
	public void setBuyOtherFee(String buyOtherFee) {
		this.buyOtherFee = buyOtherFee;
	}


	/**
	 * 获取：其他收购成本
	 */
	public String getBuyOtherFee() {
		return buyOtherFee;
	}

	/**
	 * 设置：预期库存风险期（盈亏平衡点）
	 */
	public void setBep(String bep) {
		this.bep = bep;
	}


	/**
	 * 获取：预期库存风险期（盈亏平衡点）
	 */
	public String getBep() {
		return bep;
	}

	/**
	 * 设置：库位号
	 */
	public void setSlNum(String slNum) {
		this.slNum = slNum;
	}


	/**
	 * 获取：库位号
	 */
	public String getSlNum() {
		return slNum;
	}

	/**
	 * 设置：上架销售时间
	 */
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}


	/**
	 * 获取：上架销售时间
	 */
	public String getSellDate() {
		return sellDate;
	}

	/**
	 * 设置：是否认证
	 */
	public void setIsAuth(String isAuth) {
		this.isAuth = isAuth;
	}


	/**
	 * 获取：是否认证
	 */
	public String getIsAuth() {
		return isAuth;
	}

	/**
	 * 设置：整备费用
	 */
	public void setServicingCosts(String servicingCosts) {
		this.servicingCosts = servicingCosts;
	}


	/**
	 * 获取：整备费用
	 */
	public String getServicingCosts() {
		return servicingCosts;
	}

	/**
	 * 设置：日常维护费用
	 */
	public void setUpkeep(String upkeep) {
		this.upkeep = upkeep;
	}


	/**
	 * 获取：日常维护费用
	 */
	public String getUpkeep() {
		return upkeep;
	}

	/**
	 * 设置：验车费
	 */
	public void setCheckFee(String checkFee) {
		this.checkFee = checkFee;
	}


	/**
	 * 获取：验车费
	 */
	public String getCheckFee() {
		return checkFee;
	}

	/**
	 * 设置：购买交强险
	 */
	public void setSali(String sali) {
		this.sali = sali;
	}


	/**
	 * 获取：购买交强险
	 */
	public String getSali() {
		return sali;
	}

	/**
	 * 设置：库存时间
	 */
	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}


	/**
	 * 获取：库存时间
	 */
	public String getStoreTime() {
		return storeTime;
	}

	/**
	 * 设置：是否超期
	 */
	public void setIsExceed(String isExceed) {
		this.isExceed = isExceed;
	}


	/**
	 * 获取：是否超期
	 */
	public String getIsExceed() {
		return isExceed;
	}

	/**
	 * 设置：批售起竞价/零售底价
	 */
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}


	/**
	 * 获取：批售起竞价/零售底价
	 */
	public String getMinPrice() {
		return minPrice;
	}

	/**
	 * 设置：批售保留价/零售定价
	 */
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}


	/**
	 * 获取：批售保留价/零售定价
	 */
	public String getSellPrice() {
		return sellPrice;
	}

	/**
	 * 设置：销售类型:内部转出,外部批售,零售,认证零售
	 */
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}


	/**
	 * 获取：销售类型:内部转出,外部批售,零售,认证零售
	 */
	public String getSellType() {
		return sellType;
	}

	/**
	 * 设置：销售客户来源:内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他
	 */
	public void setSellClientRef(String sellClientRef) {
		this.sellClientRef = sellClientRef;
	}


	/**
	 * 获取：销售客户来源:内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他
	 */
	public String getSellClientRef() {
		return sellClientRef;
	}

	/**
	 * 设置：推荐人
	 */
	public void setSellReferrer(String sellReferrer) {
		this.sellReferrer = sellReferrer;
	}


	/**
	 * 获取：推荐人
	 */
	public String getSellReferrer() {
		return sellReferrer;
	}

	/**
	 * 设置：推荐人职务
	 */
	public void setSellReferrerDuty(String sellReferrerDuty) {
		this.sellReferrerDuty = sellReferrerDuty;
	}


	/**
	 * 获取：推荐人职务
	 */
	public String getSellReferrerDuty() {
		return sellReferrerDuty;
	}

	/**
	 * 设置：销售人
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}


	/**
	 * 获取：销售人
	 */
	public String getSeller() {
		return seller;
	}

	/**
	 * 设置：新车主名称
	 */
	public void setNewCarOwner(String newCarOwner) {
		this.newCarOwner = newCarOwner;
	}


	/**
	 * 获取：新车主名称
	 */
	public String getNewCarOwner() {
		return newCarOwner;
	}

	/**
	 * 设置：联系电话
	 */
	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}


	/**
	 * 获取：联系电话
	 */
	public String getNewPhone() {
		return newPhone;
	}

	/**
	 * 设置：批售渠道名称（零售不需要填写）
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}


	/**
	 * 获取：批售渠道名称（零售不需要填写）
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * 设置：销售日期
	 */
	public void setSellDateFinal(String sellDateFinal) {
		this.sellDateFinal = sellDateFinal;
	}


	/**
	 * 获取：销售日期
	 */
	public String getSellDateFinal() {
		return sellDateFinal;
	}

	/**
	 * 设置：销售价格
	 */
	public void setSellPriceFinal(String sellPriceFinal) {
		this.sellPriceFinal = sellPriceFinal;
	}


	/**
	 * 获取：销售价格
	 */
	public String getSellPriceFinal() {
		return sellPriceFinal;
	}

	/**
	 * 设置：付款方式
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	/**
	 * 获取：付款方式
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * 设置：首付金额
	 */
	public void setPaymentFirstMoney(String paymentFirstMoney) {
		this.paymentFirstMoney = paymentFirstMoney;
	}


	/**
	 * 获取：首付金额
	 */
	public String getPaymentFirstMoney() {
		return paymentFirstMoney;
	}

	/**
	 * 设置：贷款金额
	 */
	public void setPaymentLoanMoney(String paymentLoanMoney) {
		this.paymentLoanMoney = paymentLoanMoney;
	}


	/**
	 * 获取：贷款金额
	 */
	public String getPaymentLoanMoney() {
		return paymentLoanMoney;
	}

	/**
	 * 设置：过户费用
	 */
	public void setTransferFee(String transferFee) {
		this.transferFee = transferFee;
	}


	/**
	 * 获取：过户费用
	 */
	public String getTransferFee() {
		return transferFee;
	}

	/**
	 * 设置：其他销售成本
	 */
	public void setSellOtherFee(String sellOtherFee) {
		this.sellOtherFee = sellOtherFee;
	}


	/**
	 * 获取：其他销售成本
	 */
	public String getSellOtherFee() {
		return sellOtherFee;
	}

	/**
	 * 设置：退商业险
	 */
	public void setRbr(String rbr) {
		this.rbr = rbr;
	}


	/**
	 * 获取：退商业险
	 */
	public String getRbr() {
		return rbr;
	}

	/**
	 * 设置：金融手续费
	 */
	public void setFhc(String fhc) {
		this.fhc = fhc;
	}


	/**
	 * 获取：金融手续费
	 */
	public String getFhc() {
		return fhc;
	}

	/**
	 * 设置：保险利润
	 */
	public void setProfitInsurance(String profitInsurance) {
		this.profitInsurance = profitInsurance;
	}


	/**
	 * 获取：保险利润
	 */
	public String getProfitInsurance() {
		return profitInsurance;
	}

	/**
	 * 设置：装饰利润
	 */
	public void setProfitDecorative(String profitDecorative) {
		this.profitDecorative = profitDecorative;
	}


	/**
	 * 获取：装饰利润
	 */
	public String getProfitDecorative() {
		return profitDecorative;
	}

	/**
	 * 设置：手续代办
	 */
	public void setFormalitieCharge(String formalitieCharge) {
		this.formalitieCharge = formalitieCharge;
	}


	/**
	 * 获取：手续代办
	 */
	public String getFormalitieCharge() {
		return formalitieCharge;
	}

	/**
	 * 设置：厂家返利
	 */
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}


	/**
	 * 获取：厂家返利
	 */
	public String getRebate() {
		return rebate;
	}

	/**
	 * 设置：其他
	 */
	public void setOther(String other) {
		this.other = other;
	}


	/**
	 * 获取：其他
	 */
	public String getOther() {
		return other;
	}

	/**
	 * 设置：进销差毛利1
	 */
	public void setMaori(String maori) {
		this.maori = maori;
	}


	/**
	 * 获取：进销差毛利1
	 */
	public String getMaori() {
		return maori;
	}

	/**
	 * 设置：收购毛利率1
	 */
	public void setMaoriRate(String maoriRate) {
		this.maoriRate = maoriRate;
	}


	/**
	 * 获取：收购毛利率1
	 */
	public String getMaoriRate() {
		return maoriRate;
	}

	/**
	 * 设置：直接成本
	 */
	public void setDirectCost(String directCost) {
		this.directCost = directCost;
	}


	/**
	 * 获取：直接成本
	 */
	public String getDirectCost() {
		return directCost;
	}

	/**
	 * 设置：毛利2
	 */
	public void setMaori2(String maori2) {
		this.maori2 = maori2;
	}


	/**
	 * 获取：毛利2
	 */
	public String getMaori2() {
		return maori2;
	}

	/**
	 * 设置：收购毛利率2
	 */
	public void setMaoriRate2(String maoriRate2) {
		this.maoriRate2 = maoriRate2;
	}


	/**
	 * 获取：收购毛利率2
	 */
	public String getMaoriRate2() {
		return maoriRate2;
	}

	/**
	 * 设置：衍生收益
	 */
	public void setOtherEarnings(String otherEarnings) {
		this.otherEarnings = otherEarnings;
	}


	/**
	 * 获取：衍生收益
	 */
	public String getOtherEarnings() {
		return otherEarnings;
	}

	/**
	 * 设置：厂家返利
	 */
	public void setRebate2(String rebate2) {
		this.rebate2 = rebate2;
	}


	/**
	 * 获取：厂家返利
	 */
	public String getRebate2() {
		return rebate2;
	}

	/**
	 * 设置：综合毛利
	 */
	public void setSynthesisMaori(String synthesisMaori) {
		this.synthesisMaori = synthesisMaori;
	}


	/**
	 * 获取：综合毛利
	 */
	public String getSynthesisMaori() {
		return synthesisMaori;
	}

	/**
	 * 设置：收购年
	 */
	public void setBuyYear(String buyYear) {
		this.buyYear = buyYear;
	}


	/**
	 * 获取：收购年
	 */
	public String getBuyYear() {
		return buyYear;
	}

	/**
	 * 设置：收购月
	 */
	public void setBuyMonth(String buyMonth) {
		this.buyMonth = buyMonth;
	}


	/**
	 * 获取：收购月
	 */
	public String getBuyMonth() {
		return buyMonth;
	}

	/**
	 * 设置：销售年
	 */
	public void setSellYear(String sellYear) {
		this.sellYear = sellYear;
	}


	/**
	 * 获取：销售年
	 */
	public String getSellYear() {
		return sellYear;
	}

	/**
	 * 设置：销售月
	 */
	public void setSellMonth(String sellMonth) {
		this.sellMonth = sellMonth;
	}


	/**
	 * 获取：销售月
	 */
	public String getSellMonth() {
		return sellMonth;
	}

	/**
	 * 设置：收购方式(采购来源=1)
	 */
	public void setBuyWay(String buyWay) {
		this.buyWay = buyWay;
	}


	/**
	 * 获取：收购方式(采购来源=1)
	 */
	public String getBuyWay() {
		return buyWay;
	}

	/**
	 * 设置：销售方式(零售=0，认证零售=1)
	 */
	public void setSellWay(String sellWay) {
		this.sellWay = sellWay;
	}


	/**
	 * 获取：销售方式(零售=0，认证零售=1)
	 */
	public String getSellWay() {
		return sellWay;
	}

	/**
	 * 设置：销售方式2
	 */
	public void setSellWay2(String sellWay2) {
		this.sellWay2 = sellWay2;
	}


	/**
	 * 获取：销售方式2
	 */
	public String getSellWay2() {
		return sellWay2;
	}

	/**
	 * 设置：车龄
	 */
	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}


	/**
	 * 获取：车龄
	 */
	public String getCarAge() {
		return carAge;
	}

	/**
	 * 设置：车龄阶梯
	 */
	public void setCarAgeLeavel(String carAgeLeavel) {
		this.carAgeLeavel = carAgeLeavel;
	}


	/**
	 * 获取：车龄阶梯
	 */
	public String getCarAgeLeavel() {
		return carAgeLeavel;
	}

	/**
	 * 设置：收车价格阶梯
	 */
	public void setBuyPriceLeavel(String buyPriceLeavel) {
		this.buyPriceLeavel = buyPriceLeavel;
	}


	/**
	 * 获取：收车价格阶梯
	 */
	public String getBuyPriceLeavel() {
		return buyPriceLeavel;
	}

	/**
	 * 设置：是否库存
	 */
	public void setIsStore(String isStore) {
		this.isStore = isStore;
	}


	/**
	 * 获取：是否库存
	 */
	public String getIsStore() {
		return isStore;
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
