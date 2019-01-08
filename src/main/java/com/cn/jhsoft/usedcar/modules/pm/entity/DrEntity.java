package com.cn.jhsoft.usedcar.modules.pm.entity;

import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;



/**
 * 置换零售业务
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
public class DrEntity implements Serializable {
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
	@NotBlank(message="年月不能为空", groups = {AddGroup.class, UpdateGroup.class})
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
     * 新车展厅建卡量
     */
	private Integer createdAmount;

    /**
     * 新车DCC邀约到店量
     */
	private Integer dccAmount;

    /**
     * 总量
     */
	private Integer allAmount;

    /**
     * 零售
     */
	private Integer retailAmount;

    /**
     * 二网
     */
	private Integer twoNetAmount;

    /**
     * 大客户
     */
	private Integer bigClientAmount;

    /**
     * 置换潜客量
     */
	private Integer latentAmount;

    /**
     * 潜客评估量
     */
	private Integer latentAssessAmount;

    /**
     * 评估成交量
     */
	private Integer latentAssessDealAmount;

    /**
     * 置换潜客率
     */
	private Float latentRate;

    /**
     * 潜客评估率
     */
	private Float latentAssessRate;

    /**
     * 评估成交率
     */
	private Float latentAssessDealRate;

    /**
     * 广义置换率
     */
	private Float generalizedRate;

    /**
     * 狭义置换率
     */
	private Float narrowlyRate;

    /**
     * 零售建卡量
     */
	private Integer sellCreatedAmount;

    /**
     * 零售成交量
     */
	private Integer sellDealAmount;

    /**
     * 零售成交转化率
     */
	private Float sellDealRate;

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
	 * 设置：新车展厅建卡量
	 */
	public void setCreatedAmount(Integer createdAmount) {
		this.createdAmount = createdAmount == null ? 0 : createdAmount;
	}


	/**
	 * 获取：新车展厅建卡量
	 */
	public Integer getCreatedAmount() {
		return createdAmount == null ? 0 : createdAmount;
	}

	/**
	 * 设置：新车DCC邀约到店量
	 */
	public void setDccAmount(Integer dccAmount) {
		this.dccAmount = dccAmount == null ? 0 : dccAmount;
	}


	/**
	 * 获取：新车DCC邀约到店量
	 */
	public Integer getDccAmount() {
		return dccAmount == null ? 0 : dccAmount;
	}

	/**
	 * 设置：总量
	 */
	public void setAllAmount(Integer allAmount) {
		this.allAmount = allAmount == null ? 0 : allAmount;
	}


	/**
	 * 获取：总量
	 */
	public Integer getAllAmount() {
		return allAmount == null ? 0 : allAmount;
	}

	/**
	 * 设置：零售
	 */
	public void setRetailAmount(Integer retailAmount) {
		this.retailAmount = retailAmount == null ? 0 : retailAmount;
	}


	/**
	 * 获取：零售
	 */
	public Integer getRetailAmount() {
		return retailAmount == null ? 0 : retailAmount;
	}

	/**
	 * 设置：二网
	 */
	public void setTwoNetAmount(Integer twoNetAmount) {
		this.twoNetAmount = twoNetAmount == null ? 0 : twoNetAmount;
	}


	/**
	 * 获取：二网
	 */
	public Integer getTwoNetAmount() {
		return twoNetAmount == null ? 0 : twoNetAmount;
	}

	/**
	 * 设置：大客户
	 */
	public void setBigClientAmount(Integer bigClientAmount) {
		this.bigClientAmount = bigClientAmount == null ? 0 : bigClientAmount;
	}


	/**
	 * 获取：大客户
	 */
	public Integer getBigClientAmount() {
		return bigClientAmount == null ? 0 : bigClientAmount;
	}

	/**
	 * 设置：置换潜客量
	 */
	public void setLatentAmount(Integer latentAmount) {
		this.latentAmount = latentAmount == null ? 0 : latentAmount;
	}


	/**
	 * 获取：置换潜客量
	 */
	public Integer getLatentAmount() {
		return latentAmount == null ? 0 : latentAmount;
	}

	/**
	 * 设置：潜客评估量
	 */
	public void setLatentAssessAmount(Integer latentAssessAmount) {
		this.latentAssessAmount = latentAssessAmount == null ? 0 : latentAssessAmount;
	}


	/**
	 * 获取：潜客评估量
	 */
	public Integer getLatentAssessAmount() {
		return latentAssessAmount == null ? 0 : latentAssessAmount;
	}

	/**
	 * 设置：评估成交量
	 */
	public void setLatentAssessDealAmount(Integer latentAssessDealAmount) {
		this.latentAssessDealAmount = latentAssessDealAmount == null ? 0 : latentAssessDealAmount;
	}


	/**
	 * 获取：评估成交量
	 */
	public Integer getLatentAssessDealAmount() {
		return latentAssessDealAmount == null ? 0 : latentAssessDealAmount;
	}

	/**
	 * 设置：置换潜客率
	 */
	public void setLatentRate(Float latentRate) {
		this.latentRate = latentRate == null ? 0 : latentRate;
	}


	/**
	 * 获取：置换潜客率
	 */
	public Float getLatentRate() {
		return latentRate == null ? 0 : latentRate;
	}

	/**
	 * 设置：潜客评估率
	 */
	public void setLatentAssessRate(Float latentAssessRate) {
		this.latentAssessRate = latentAssessRate == null ? 0 : latentAssessRate;
	}


	/**
	 * 获取：潜客评估率
	 */
	public Float getLatentAssessRate() {
		return latentAssessRate == null ? 0 : latentAssessRate;
	}

	/**
	 * 设置：评估成交率
	 */
	public void setLatentAssessDealRate(Float latentAssessDealRate) {
		this.latentAssessDealRate = latentAssessDealRate == null ? 0 : latentAssessDealRate;
	}


	/**
	 * 获取：评估成交率
	 */
	public Float getLatentAssessDealRate() {
		return latentAssessDealRate == null ? 0 : latentAssessDealRate;
	}

	/**
	 * 设置：广义置换率
	 */
	public void setGeneralizedRate(Float generalizedRate) {
		this.generalizedRate = generalizedRate == null ? 0 : generalizedRate;
	}


	/**
	 * 获取：广义置换率
	 */
	public Float getGeneralizedRate() {
		return generalizedRate == null ? 0 : generalizedRate;
	}

	/**
	 * 设置：狭义置换率
	 */
	public void setNarrowlyRate(Float narrowlyRate) {
		this.narrowlyRate = narrowlyRate == null ? 0 : narrowlyRate;
	}


	/**
	 * 获取：狭义置换率
	 */
	public Float getNarrowlyRate() {
		return narrowlyRate == null ? 0 : narrowlyRate;
	}

	/**
	 * 设置：零售建卡量
	 */
	public void setSellCreatedAmount(Integer sellCreatedAmount) {
		this.sellCreatedAmount = sellCreatedAmount == null ? 0 : sellCreatedAmount;
	}


	/**
	 * 获取：零售建卡量
	 */
	public Integer getSellCreatedAmount() {
		return sellCreatedAmount == null ? 0 : sellCreatedAmount;
	}

	/**
	 * 设置：零售成交量
	 */
	public void setSellDealAmount(Integer sellDealAmount) {
		this.sellDealAmount = sellDealAmount == null ? 0 : sellDealAmount;
	}


	/**
	 * 获取：零售成交量
	 */
	public Integer getSellDealAmount() {
		return sellDealAmount == null ? 0 : sellDealAmount;
	}

	/**
	 * 设置：零售成交转化率
	 */
	public void setSellDealRate(Float sellDealRate) {
		this.sellDealRate = sellDealRate == null ? 0 : sellDealRate;
	}


	/**
	 * 获取：零售成交转化率
	 */
	public Float getSellDealRate() {
		return sellDealRate == null ? 0 : sellDealRate;
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
