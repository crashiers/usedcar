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
  `business_stage` varchar(64) DEFAULT '' COMMENT '业务阶段',
  `tier` varchar(64) DEFAULT '' COMMENT '层级',
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
  `answer` varchar(32) COMMENT '答案',
  `full_score` int DEFAULT 0 COMMENT '满分',
  `score` float DEFAULT 0 COMMENT '得分',
  `create_date` varchar(16) COMMENT '答题日期',
  `create_time` bigint COMMENT '答题时间戳',
  `create_datetime` varchar(32) COMMENT '答题时间',
  `createdip` varchar(16) DEFAULT '0.0.0.0' COMMENT '答题IP',
  `create_adminid` bigint DEFAULT 0 COMMENT '答题人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='评测结果';


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
insert into tbl_basic_data values (45, 8, '', '客户维系与开发', 3, '0:4:8:', 5, '2018-12-22 17:10:10', 1);

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
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('1', '评测系统', 'modules/pm/evalstage.html', NULL, '1', 'fa fa-bullhorn', '12');
set @evalRootId = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @evalRootId, '使用', null, 'pm:evalstage:list,pm:evalstage:info,pm:evalstage:used,pm:evalresult:list,pm:evalresult:info', '2', null, '6';
set @evalUse = @@identity;
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT @evalRootId, '评测管理', null, 'pm:evalstage:manager', '2', null, '6';

insert into sys_role (role_id, role_name) values(1,'客户');
insert into sys_role_menu (role_id, menu_id) values(1,1);
insert into sys_role_menu (role_id, menu_id) values(1,@evalRootId);
insert into sys_role_menu (role_id, menu_id) values(1,@evalUse);