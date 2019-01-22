-- 评测问题
DROP TABLE IF EXISTS `tbl_eval_question`;
CREATE TABLE IF NOT EXISTS `tbl_eval_question` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `num` int COMMENT '序号',
  `title` varchar(512) COMMENT '条目',
  `full_score` int DEFAULT 0 COMMENT '满分',
  `evaluate_way` varchar(256) DEFAULT '是,否' COMMENT '评价方式',
  `evaluate_way_score` varchar(256) DEFAULT '100,0' COMMENT '评价方式分数百分比',
  `category1` varchar(64) COMMENT '一级分类',
  `category2` varchar(64) COMMENT '二级分类',
  `category3` varchar(64) COMMENT '三级分类',
  `business_stage` varchar(64) DEFAULT '' COMMENT '业务阶段,置换/零售',
  `tier` varchar(64) DEFAULT '' COMMENT '层级,管理层/运营层/执行层',
  `personnel_ability1` varchar(64) DEFAULT '' COMMENT '人员能力1',
  `personnel_ability2` varchar(64) DEFAULT '' COMMENT '人员能力2',
  `check_content` varchar(128) DEFAULT '' COMMENT '检查内容',
  `remark` varchar(256) DEFAULT '' COMMENT '备注',
  `create_date` varchar(16) COMMENT '添加日期',
  `create_time` bigint COMMENT '添加时间戳',
  `create_datetime` varchar(32) COMMENT '添加时间',
  `createdip` varchar(16) DEFAULT '0.0.0.0' COMMENT '发表IP',
  `create_adminid` bigint DEFAULT 0 COMMENT '添加人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='评测问题';


-- 评测批次
DROP TABLE IF EXISTS `tbl_eval_stage`;
CREATE TABLE IF NOT EXISTS `tbl_eval_stage` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dealer_id` bigint DEFAULT 0 COMMENT '经销商ID',
  `stage_num` varchar(32) COMMENT '批次编号',
  `score1` float DEFAULT 0 COMMENT '业务规划',
  `score2` float DEFAULT 0 COMMENT '业务运营',
  `score3` float DEFAULT 0 COMMENT '业务推广',
  `score4` float DEFAULT 0 COMMENT '业务执行',
  `score5` float DEFAULT 0 COMMENT '置换流程',
  `score6` float DEFAULT 0 COMMENT '零售流程',
  `score7` float DEFAULT 0 COMMENT '管理层',
  `score8` float DEFAULT 0 COMMENT '运营层',
  `score9` float DEFAULT 0 COMMENT '执行层',
  `create_date` varchar(16) COMMENT '提交日期',
  `create_datetime` varchar(32) COMMENT '提交时间',
  `create_adminid` bigint DEFAULT 0 COMMENT '答题人ID',
  `create_admin` varchar(128) COMMENT '答题人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='评测批次';

-- 评测结果
DROP TABLE IF EXISTS `tbl_eval_result`;
CREATE TABLE IF NOT EXISTS `tbl_eval_result` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `question_num` int COMMENT '题目序号',
  `stage_id` bigint COMMENT '答题批次ID',
  `stage_num` varchar(32) COMMENT '答题批次编号',
  `dealer_id` bigint DEFAULT 0 COMMENT '经销商ID',
  `dealer_name` varchar(512) COMMENT '经销商名称',
  `answer` varchar(32) COMMENT '答案',
  `full_score` int DEFAULT 0 COMMENT '满分',
  `answer_score` FLOAT DEFAULT 0 COMMENT '答案对应的分值比例',
  `score` float DEFAULT 0 COMMENT '得分',
  `create_date` varchar(16) COMMENT '答题日期',
  `create_time` bigint COMMENT '答题时间戳',
  `create_datetime` varchar(32) COMMENT '答题时间',
  `createdip` varchar(16) DEFAULT '0.0.0.0' COMMENT '答题IP',
  `create_adminid` bigint DEFAULT 0 COMMENT '答题人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='评测结果';

-- 经销商
DROP TABLE IF EXISTS `tbl_dealer`;
CREATE TABLE IF NOT EXISTS `tbl_dealer` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(512) COMMENT '名称',
  `province` varchar(64) COMMENT '省',
  `city` varchar(128) COMMENT '市',
  `district` varchar(128) COMMENT '区',
  `address` varchar(512) COMMENT '地址',
  `relname` varchar(64) COMMENT '联系人',
  `tel` varchar(32) COMMENT '联系电话',
  `email` varchar(100) COMMENT '邮箱',
  `mobile` varchar(100) COMMENT '手机号',
  `basement_client_sum` bigint COMMENT '基盘客户量',
  `business_mode` varchar(64) COMMENT '二手车业务模式,单店运营、集团运营、单店+集团、集团+单店、第三方运营、无人运营、内部承包',
  `superior` varchar(64) COMMENT '二手车部门主管上级,集团二手车部、公司总经理、销售总监、增值总监、售后总监、第三方或无部门',

  `dep_persons` varchar(16) COMMENT '部门人数',
  `manager_workway` varchar(16) COMMENT '二手车经理,专职、兼职',
  `appraiserz` varchar(16) COMMENT '专职评估师人数',
  `appraiserj` varchar(16) COMMENT '兼职评估师人数',
  `sellerz` varchar(16) COMMENT '专职二手车销售顾问人数',
  `sellerj` varchar(16) COMMENT '兼职二手车销售顾问人数',
  `messengerz` varchar(16) COMMENT '专职信息员人数',
  `messengerj` varchar(16) COMMENT '兼职信息员人数',
  `preparingz` varchar(16) COMMENT '专职整备技师人数',
  `preparingj` varchar(16) COMMENT '兼职整备技师人数',
  `newz` varchar(16) COMMENT '专职翻新技师人数',
  `newj` varchar(16) COMMENT '兼职翻新技师人数',
  `assignedz` varchar(16) COMMENT '专职过户专员人数',
  `assignedj` varchar(16) COMMENT '兼职过户专员人数',

  `exhibition` varchar(16) COMMENT '展厅销售顾问人数',
  `idcc` varchar(16) COMMENT 'IDCC专员人数',
  `internship` varchar(16) COMMENT '实习销售顾问人数',

  `newcar_seller` varchar(128) COMMENT '新车销售顾问',
  `sales_director` varchar(128) COMMENT '销售总监',
  `appraiser` varchar(128) COMMENT '评估师',
  `messenger_person` varchar(128) COMMENT '信息员',
  `transfer_person` varchar(128) COMMENT '过户专员',
  `renovate_person` varchar(128) COMMENT '翻新技师',
  `hostling_person` varchar(128) COMMENT '整备技师',
  `usedcar_seller` varchar(128) COMMENT '二手车销售顾问',
  `usedcar_manager` varchar(128) COMMENT '二手车经理',

  `newcar_seller2` varchar(128) COMMENT '新车销售顾问',
  `appraiser2` varchar(128) COMMENT '评估师',
  `usedcar_seller2` varchar(128) COMMENT '二手车销售顾问',
  `messenger_person2` varchar(128) COMMENT '信息员',
  `renovate_person2` varchar(128) COMMENT '翻新技师',
  `hostling_person2` varchar(128) COMMENT '整备技师',
  `transfer_person2` varchar(128) COMMENT '过户专员',
  `usedcar_manager2` varchar(128) COMMENT '二手车经理',

  `fund_source` varchar(64) COMMENT '运营资金来源,专项、新车款、无资金',
  `fund_amount` varchar(8) COMMENT '运营资金额度(万)',
  `sale_mode` varchar(64) COMMENT '销售模式,转售、批售、零售、批售+零售、零售+批售、寄售',
  `marketing_remark` varchar(1024) COMMENT '营销情况简述',
  `dealer_feature` varchar(1024) COMMENT '经销商特征描述（店址分析、销售和售后经营状况、二手车基础情况等）',
  `manager_layer` varchar(512) COMMENT '管理层意识与能力',
  `operation_layer` varchar(512) COMMENT '运营层意识与能力（二手车总监和二手车总监）',
  `executive_layer` varchar(512) COMMENT '二手车人员意识与能力（执行层人员）',
  `permute_stage` varchar(64) COMMENT '置换业务所处阶段,筹备阶段、起步阶段、提升阶段、增量阶段',
  `sell_stage` varchar(64) COMMENT '零售业务所处阶段,零售未开展、起步阶段、提升阶段、专业阶段',
  `question` varchar(1024) COMMENT '经销商核心问题',
  `forecast` varchar(64) COMMENT '提升预测,可改善、难以改善',
  `remark` varchar(1024) COMMENT '备注',
  `brand` varchar(64) COMMENT '经销品牌ID',
  `brandname` varchar(64) COMMENT '经销品牌名称',
  `create_date` varchar(16) COMMENT '添加日期',
  `create_datetime` varchar(32) COMMENT '添加时间',
  `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='经销商';


-- 置换零售业务
DROP TABLE IF EXISTS `tbl_dr`;
CREATE TABLE IF NOT EXISTS `tbl_dr` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dealer_id` bigint COMMENT '经销商ID',
  `year_month` varchar(16) COMMENT '年月',
  `year` varchar(4) COMMENT '年',
  `month` varchar(4) COMMENT '月',
  `created_amount` int COMMENT '新车展厅建卡量',
  `dcc_amount` int COMMENT '新车DCC邀约到店量',
  `all_amount` int COMMENT '总量',
  `retail_amount` int COMMENT '零售',
  `two_net_amount` int COMMENT '二网',
  `big_client_amount` int COMMENT '大客户',
  `latent_amount` int COMMENT '置换潜客量',
  `latent_assess_amount` int COMMENT '潜客评估量',
  `latent_assess_deal_amount` int COMMENT '评估成交量',
  `latent_rate` float COMMENT '置换潜客率',
  `latent_assess_rate` float COMMENT '潜客评估率',
  `latent_assess_deal_rate` float COMMENT '评估成交率',
  `generalized_rate` float COMMENT '广义置换率',
  `narrowly_rate` float COMMENT '狭义置换率',
  `sell_created_amount` int COMMENT '零售建卡量',
  `sell_deal_amount` int COMMENT '零售成交量',
  `sell_deal_rate` float COMMENT '零售成交转化率',
  `create_date` varchar(16) COMMENT '添加日期',
  `create_datetime` varchar(32) COMMENT '添加时间',
  `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='置换零售业务';


-- 置换零售量
DROP TABLE IF EXISTS `tbl_dra`;
CREATE TABLE IF NOT EXISTS `tbl_dra` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dealer_id` bigint COMMENT '经销商ID',
  `year_month` varchar(16) COMMENT '年月',
  `year` varchar(4) COMMENT '年',
  `month` varchar(4) COMMENT '月',
  `brand` varchar(64) COMMENT '品牌',
  `arctic` varchar(64) COMMENT '车型',
  `atype` int COMMENT '类型,1置换,2零售',
  `amount` int COMMENT '数量',
  `create_date` varchar(16) COMMENT '添加日期',
  `create_datetime` varchar(32) COMMENT '添加时间',
  `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Index2` (`year_month`, `atype`, `arctic`, `dealer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='置换零售量';


-- 进销存
DROP TABLE IF EXISTS `tbl_drp`;
CREATE TABLE IF NOT EXISTS `tbl_drp` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dealer_id` bigint COMMENT '经销商ID',
  `num` bigint COMMENT '序号',
  `rkdh` varchar(32) COMMENT '入库号',
  `brand` varchar(64) COMMENT '品牌',
  `arctic` varchar(64) COMMENT '车型',
  `car_model` varchar(64) COMMENT '车款',
  `color` varchar(16) COMMENT '颜色',
  `mileage` varchar(32) COMMENT '表征里程',
  `first_date` varchar(32) COMMENT '初登日期',
  `displacement` varchar(32) COMMENT '排量',
  `gearbox` varchar(32) COMMENT '变速箱',
  `vin` varchar(32) COMMENT '车架号',
  `remark` varchar(512) COMMENT '车况简述',
  `buy_type` varchar(32) COMMENT '收购类型:置换收购,直客收购,渠道收购,车辆寄售,内部转入',
  `buy_client_ref` varchar(32) COMMENT '收购客户来源:基盘客户挖掘,内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他',
  `buy_company` varchar(128) COMMENT '收购单位',
  `buy_referrer` varchar(32) COMMENT '推荐人',
  `buy_referrer_duty` varchar(64) COMMENT '推荐人职务',
  `buyer` varchar(32) COMMENT '收购人',
  `raw_car_owner` varchar(32) COMMENT '旧车主姓名',
  `raw_phone` varchar(32) COMMENT '联系电话',
  `permute_arctic` varchar(64) COMMENT '置换车型',
  `buy_date` varchar(32) COMMENT '收购日期',
  `buy_price` varchar(32) COMMENT '收购价格',
  `buy_transfer_fee` varchar(32) COMMENT '过户费用',
  `buy_other_fee` varchar(32) COMMENT '其他收购成本',
  `bep` varchar(32) COMMENT '预期库存风险期（盈亏平衡点）',
  `sl_num` varchar(32) COMMENT '库位号',
  `sell_date` varchar(32) COMMENT '上架销售时间',
  `is_auth` varchar(32) COMMENT '是否认证',
  `servicing_costs` varchar(32) COMMENT '整备费用',
  `upkeep` varchar(32) COMMENT '日常维护费用',
  `check_fee` varchar(32) COMMENT '验车费',
  `sali` varchar(32) COMMENT '购买交强险',
  `store_time` varchar(32) COMMENT '库存时间',
  `is_exceed` varchar(32) COMMENT '是否超期',
  `min_price` varchar(32) COMMENT '批售起竞价/零售底价',
  `sell_price` varchar(32) COMMENT '批售保留价/零售定价',
  `sell_type` varchar(32) COMMENT '销售类型:内部转出,外部批售,零售,认证零售',
  `sell_client_ref` varchar(32) COMMENT '销售客户来源:内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他',
  `sell_referrer` varchar(32) COMMENT '推荐人',
  `sell_referrer_duty` varchar(64) COMMENT '推荐人职务',
  `seller` varchar(32) COMMENT '销售人',
  `new_car_owner` varchar(32) COMMENT '新车主名称',
  `new_phone` varchar(32) COMMENT '联系电话',
  `channel` varchar(32) COMMENT '批售渠道名称（零售不需要填写）',
  `sell_date_final` varchar(32) COMMENT '销售日期',
  `sell_price_final` varchar(32) COMMENT '销售价格',
  `payment_type` varchar(32) COMMENT '付款方式',
  `payment_first_money` varchar(32) COMMENT '首付金额',
  `payment_loan_money` varchar(32) COMMENT '贷款金额',
  `transfer_fee` varchar(32) COMMENT '过户费用',
  `sell_other_fee` varchar(32) COMMENT '其他销售成本',
  `rbr` varchar(32) COMMENT '退商业险',
  `fhc` varchar(32) COMMENT '金融手续费',
  `profit_insurance` varchar(32) COMMENT '保险利润',
  `profit_decorative` varchar(32) COMMENT '装饰利润',
  `formalitie_charge` varchar(32) COMMENT '手续代办',
  `rebate` varchar(32) COMMENT '厂家返利',
  `other` varchar(32) COMMENT '其他',
  `maori` varchar(32) COMMENT '进销差毛利1',
  `maori_rate` varchar(32) COMMENT '收购毛利率1',
  `direct_cost` varchar(32) COMMENT '直接成本',
  `maori2` varchar(32) COMMENT '毛利2',
  `maori_rate2` varchar(32) COMMENT '收购毛利率2',
  `other_earnings` varchar(32) COMMENT '衍生收益',
  `rebate2` varchar(32) COMMENT '厂家返利',
  `synthesis_maori` varchar(32) COMMENT '综合毛利，这之后的列都不要了',
  `buy_year` varchar(8) COMMENT '收购年',
  `buy_month` varchar(8) COMMENT '收购月',
  `sell_year` varchar(8) COMMENT '销售年',
  `sell_month` varchar(8) COMMENT '销售月',
  `buy_way` varchar(32) COMMENT '收购方式(采购来源=1)',
  `sell_way` varchar(32) COMMENT '销售方式(零售=0，认证零售=1)',
  `sell_way2` varchar(32) COMMENT '销售方式2',
  `car_age` varchar(16) COMMENT '车龄',
  `car_age_leavel` varchar(32) COMMENT '车龄阶梯',
  `buy_price_leavel` varchar(32) COMMENT '收车价格阶梯',
  `is_store` varchar(32) COMMENT '是否库存',
  `create_date` varchar(16) COMMENT '添加日期',
  `create_datetime` varchar(32) COMMENT '添加时间',
  `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='进销存';


-- 分类初始化
insert into tbl_basic_data values (4, 0, 'board', '评测版块', 1, '0:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (5, 4, 'business_planning', '业务规划', 2, '0:4:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (6, 4, 'business_operator', '业务运营', 2, '0:4:', 2, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (7, 4, 'business_generalize', '业务推广', 2, '0:4:', 3, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (8, 4, 'business_execute', '业务执行', 2, '0:4:', 4, '2018-12-22 17:10:10', 1);

-- 初始化二级分类
insert into tbl_basic_data values (12, 5, '', '宏观规划', 3, '0:4:5:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (13, 5, '', '业务目标', 3, '0:4:5:', 2, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (14, 5, '', '基础配备', 3, '0:4:5:', 3, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (15, 5, '', '流程设计', 3, '0:4:5:', 4, '2018-12-22 17:10:10', 1);

insert into tbl_basic_data values (21, 6, '', '目标分解', 3, '0:4:6:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (22, 6, '', '绩效制定', 3, '0:4:6:', 2, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (23, 6, '', '流程制定', 3, '0:4:6:', 3, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (24, 6, '', '信息系统', 3, '0:4:6:', 4, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (25, 6, '', '业务管理', 3, '0:4:6:', 5, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (26, 6, '', '业务监控', 3, '0:4:6:', 6, '2018-12-22 17:10:10', 1);

insert into tbl_basic_data values (31, 7, '', '设计能力', 3, '0:4:7:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (32, 7, '', '全员营销', 3, '0:4:7:', 2, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (33, 7, '', '展厅营销', 3, '0:4:7:', 3, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (34, 7, '', '活动营销', 3, '0:4:7:', 4, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (35, 7, '', '媒体推广', 3, '0:4:7:', 5, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (36, 7, '', '基盘推广', 3, '0:4:7:', 6, '2018-12-22 17:10:10', 1);

insert into tbl_basic_data values (41, 8, '', '车辆收购', 3, '0:4:8:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (42, 8, '', '整备翻新', 3, '0:4:8:', 2, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (43, 8, '', '车辆展示', 3, '0:4:8:', 3, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (44, 8, '', '车辆销售', 3, '0:4:8:', 4, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (45, 8, '', '客户维系', 3, '0:4:8:', 5, '2018-12-22 17:10:10', 1);

-- 三级 - 车辆收购
insert into tbl_basic_data values (51, 41, 'swap', '客户接待', 4, '0:4:8:41:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (52, 41, 'swap', '车辆评估', 4, '0:4:8:41:', 2, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (53, 41, 'swap', '报价商谈', 4, '0:4:8:41:', 3, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (54, 41, 'swap', '车辆收购', 4, '0:4:8:41:', 4, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (55, 41, 'swap', '客户回访', 4, '0:4:8:41:', 5, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (56, 41, '', '直接收购', 4, '0:4:8:41:', 6, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (57, 41, '', '渠道采购', 4, '0:4:8:41:', 7, '2018-12-22 17:10:10', 1);

insert into tbl_basic_data values (61, 44, 'resale', '获取客户', 4, '0:4:8:44:', 1, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (62, 44, 'resale', '展厅接待', 4, '0:4:8:44:', 2, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (63, 44, 'resale', '需求分析', 4, '0:4:8:44:', 3, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (64, 44, 'resale', '产品介绍', 4, '0:4:8:44:', 4, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (65, 44, 'resale', '报价商谈', 4, '0:4:8:44:', 5, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (66, 44, 'resale', '试乘试驾', 4, '0:4:8:44:', 6, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (67, 44, 'resale', '签约成交', 4, '0:4:8:44:', 7, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (68, 44, 'resale', '车辆交付', 4, '0:4:8:44:', 8, '2018-12-22 17:10:10', 1);
insert into tbl_basic_data values (69, 44, '', '批售', 4, '0:4:8:44:', 9, '2018-12-22 17:10:10', 1);


-- 初始化系统参数
insert into sys_config (`key`, `value`, remark) values('answerMaxTime', '3', '答题最长时间，3天');

-- 题目管理菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('1', '题目管理', 'modules/pm/evalquestion.html', NULL, '1', 'fa fa-sticky-note', '11');
set @parentId = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '查看', null, 'pm:evalquestion:list,pm:evalquestion:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '新增', null, 'pm:evalquestion:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '导入', null, 'pm:evalquestion:upload', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '修改', null, 'pm:evalquestion:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '删除', null, 'pm:evalquestion:delete', '2', null, '6';

-- 评测系统
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('1', '评测系统', 'modules/pm/evalstage.html', NULL, '1', 'fa fa-bullhorn', '13');
set @evalRootId = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @evalRootId, '使用', null, 'pm:evalstage:list,pm:evalstage:info,pm:evalstage:used,pm:evalresult:list,pm:evalresult:info', '2', null, '6';
set @evalUse = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @evalRootId, '评测管理', null, 'pm:evalstage:manager', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @evalRootId, '机器人考试', null, 'pm:evalstage:evaljqr', '2', null, '6';

insert into sys_role (role_id, role_name) values(1,'客户');
insert into sys_role_menu (role_id, menu_id) values(1,1);
insert into sys_role_menu (role_id, menu_id) values(1,@evalRootId);
insert into sys_role_menu (role_id, menu_id) values(1,@evalUse);


-- 经销商菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('1', '经销商', 'modules/pm/dealer.html', NULL, '1', 'fa fa-briefcase', '12');
set @parentId = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '查看', null, 'pm:dealer:list,pm:dealer:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '新增', null, 'pm:dealer:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '修改', null, 'pm:dealer:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '删除', null, 'pm:dealer:delete', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '管理', null, 'pm:dealer:manager', '2', null, '6';

-- 置换零售业务菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('1', '置换零售业务', 'modules/pm/dr.html', NULL, '1', 'fa fa-sellsy', '14');
set @parentId = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '查看', null, 'pm:dr:list,pm:dr:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '新增', null, 'pm:dr:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '修改', null, 'pm:dr:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '删除', null, 'pm:dr:delete', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '管理', null, 'pm:dr:manager', '2', null, '6';

-- 进销存菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('1', '进销存', 'modules/pm/drp.html', NULL, '1', 'fa fa-laptop', '15');
set @parentId = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '查看', null, 'pm:drp:list,pm:drp:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '新增', null, 'pm:drp:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '修改', null, 'pm:drp:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '删除', null, 'pm:drp:delete', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @parentId, '管理', null, 'pm:drp:manager', '2', null, '6';




-- 初始化品牌和子品牌
insert into tbl_basic_data (parent_id, ename, `name`) select 0,'brand', '品牌';
set @parent_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '上汽大众';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '帕萨特';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '途观';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '途安';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '朗逸';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '朗行';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '朗境';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'POLO';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '桑塔纳';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '凌渡';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '途观L';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '途昂';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '辉昂';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '一汽大众';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '迈腾';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '速腾';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '高尔夫';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '嘉旅';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'CC';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '宝来';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷达';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '蔚领';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '探歌';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '一汽奥迪';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'A1';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'A3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'A4';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'A5';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'A6';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'A7';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'A8';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'Q3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'Q5';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'Q7';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'TT';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'R8';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '东风日产';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '玛驰';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '阳光';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '蓝鸟';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '骐达';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '轩逸';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '天籁';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '西玛';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '逍客';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '奇骏';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '楼兰';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '骊威';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '途乐';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';

insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '广汽菲克';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '酷威';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '300C';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '大捷龙';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '自由侠';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '自由客';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '指南者';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '自由光';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '牧马人';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '大切诺基';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '菲翔';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '致悦';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '菲跃';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '广汽丰田';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '致炫';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '雅力士';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '雷凌';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '凯美瑞';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '汉兰达';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '逸致';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '雷克萨斯';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'CT';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'IS';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'ES';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'LS';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'NX';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'RX';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GX';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'LX';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '斯柯达';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '野帝';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '速派';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '全新明锐';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '明锐经典款';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '昕锐';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '昕动';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '晶锐';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '通用别克';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '昂科拉';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '昂科威';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GL8';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '君威';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '君越';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '凯越';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '威朗';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '英朗';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '长安福特';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '福睿斯';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '翼博';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '福克斯';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '新蒙迪欧';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '翼虎';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '锐界';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '金牛座';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '探险者';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '广汽本田';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '冠道';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '缤智';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '雅阁';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '飞度';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '凌派';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '奥德赛';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '锋范';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '歌诗图';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '锋范经典';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '雅阁混动';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '一汽丰田';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '威驰';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '威驰FS';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '卡罗拉';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '卡罗拉双擎';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'RAV4荣放';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '皇冠';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '普拉多';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '普瑞维亚';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '86';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '海狮';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '柯斯达（中巴）';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '广汽传祺';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GA3S';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS5S';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GA6';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GA8';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS8 320T';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS4 1.3T';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS4 1.5T';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS4 PHEV';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GA3S PHEV';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GE3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS7';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'GS3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '长安马自达';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'CX-3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'CX-5';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '昂克赛拉';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '马自达2';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '马自达3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '马自达3星骋';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '东风悦达起亚';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'KX CROSS';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '焕驰';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '起亚K2';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '起亚K3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '福瑞迪';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '起亚K4';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '起亚K5';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '凯绅';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '起亚KX3';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '起亚KX5';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '起亚KX7';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '智跑';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '捷豹路虎';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷豹XEL';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷豹XFL';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷豹XE';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷豹XF';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷豹XJ';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷豹F-PACE';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '捷豹F-TYPE';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '发现神行';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '揽胜极光';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '揽胜极光(进口)';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '揽胜星脉';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '发现';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '揽胜运动版';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '揽胜';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '揽胜运动版新能源';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '沃尔沃';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'S60';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'S60L';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'S60L新能源';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'S90';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'V40';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'V60';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'V90';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'XC60';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'XC60新能源';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'XC90';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'XC90新能源';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '东风本田';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '杰德';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '思域';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '哥瑞';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '竞瑞';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '思铂睿';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'XR-V';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'CR-V';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'UR-V';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '艾力绅';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


insert into tbl_basic_data (parent_id, ename, `name`) select @parent_id, '', '一汽奔腾';
set @child_id = @@identity;
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'B30';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'B50';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'B70';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'B90';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'X40';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', 'X80';
insert into tbl_basic_data (parent_id, ename, `name`) select @child_id, '', '本品牌其他车型';


