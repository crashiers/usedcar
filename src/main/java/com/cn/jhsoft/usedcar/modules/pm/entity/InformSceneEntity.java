package com.cn.jhsoft.usedcar.modules.pm.entity;

import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;


/**
 * 通知平台-通知场景
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-07-27 11:02:26
 */
public class InformSceneEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**
     * 
     */
	private Long id;

    /**
     * 场景
     */
	@NotBlank(message="场景不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String scene;

    /**
     * 库名
     */
	@NotBlank(message="库名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String dbName;

    /**
     * 表名
     */
	@NotBlank(message="表名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String tableName;

    /**
     * 查询条件
     */
	@NotBlank(message="查询条件不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String fields;

    /**
     * 通知人
     */
	@NotBlank(message="通知人不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String informant;

    /**
     * 通知主题模板
     */
	@NotBlank(message="通知主题模板不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String informTheme;

    /**
     * 通知内容模板
     */
	@NotBlank(message="通知内容模板不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String informContent;

    /**
     * 提交人
     */
	private String createErp;

    /**
     * 日期
     */
	private String createDate;

    /**
     * 时间
     */
	private String createTime;

    /**
     * 时间戳
     */
	private Long createTimestamp;


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
	 * 设置：场景
	 */
	public void setScene(String scene) {
		this.scene = scene;
	}


	/**
	 * 获取：场景
	 */
	public String getScene() {
		return scene;
	}

	/**
	 * 设置：库名
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}


	/**
	 * 获取：库名
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * 设置：表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	/**
	 * 获取：表名
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * 设置：查询条件
	 */
	public void setFields(String fields) {
		this.fields = fields;
	}


	/**
	 * 获取：查询条件
	 */
	public String getFields() {
		return fields;
	}

	/**
	 * 设置：通知人
	 */
	public void setInformant(String informant) {
		this.informant = informant;
	}


	/**
	 * 获取：通知人
	 */
	public String getInformant() {
		return informant;
	}

	/**
	 * 设置：通知主题模板
	 */
	public void setInformTheme(String informTheme) {
		this.informTheme = informTheme;
	}


	/**
	 * 获取：通知主题模板
	 */
	public String getInformTheme() {
		return informTheme;
	}

	/**
	 * 设置：通知内容模板
	 */
	public void setInformContent(String informContent) {
		this.informContent = informContent;
	}


	/**
	 * 获取：通知内容模板
	 */
	public String getInformContent() {
		return informContent;
	}

	/**
	 * 设置：提交人
	 */
	public void setCreateErp(String createErp) {
		this.createErp = createErp;
	}


	/**
	 * 获取：提交人
	 */
	public String getCreateErp() {
		return createErp;
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
	 * 设置：时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	/**
	 * 获取：时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：时间戳
	 */
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}


	/**
	 * 获取：时间戳
	 */
	public Long getCreateTimestamp() {
		return createTimestamp;
	}

}
