DELETE FROM `tbl_eval_question`;
INSERT INTO `tbl_eval_question` (`id`, `num`, `title`, `full_score`, `evaluate_way`, `evaluate_way_score`, `category1`, `category2`, `category3`, `business_stage`, `tier`, `personnel_ability1`, `personnel_ability2`, `check_content`, `remark`, `create_date`, `create_time`, `create_datetime`, `createdip`, `create_adminid`) VALUES
	(1, 1, '制定了清晰、明确的战略定位方案？（产品、客户群、价位、服务、品牌化）', 15, '是,否', '100,0', '业务规划', '宏观规划', '', '', '管理层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(2, 2, '对基盘客户进行了调研与分析？', 10, '是,否', '100,0', '业务规划', '宏观规划', '', '', '管理层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(3, 3, '对目标潜在客户关注点进行了调研与分析？', 10, '是,否', '100,0', '业务规划', '宏观规划', '', '', '管理层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(4, 4, '对所处区域内竞争对手与产品进行了分析？', 15, '是,否', '100,0', '业务规划', '宏观规划', '', '', '管理层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(5, 5, '设定了年/季度“置换量/率”目标？', 50, '完全有依据,部分有依据,无依据,未规划', '100,60,30,0', '业务规划', '业务目标', '', '', '管理层', '', '', '业务目标文件', '', NULL, NULL, NULL, '', 0),
	(6, 6, '下达了年度/季度的经营量目标规划发文？', 50, '完全有依据,部分有依据,无依据,未规划', '100,60,30,0', '业务规划', '业务目标', '', '', '管理层', '', '', '业务目标文件', '', NULL, NULL, NULL, '', 0),
	(7, 7, '下达了年度/季度的财务考核指标？（毛利率及其他）', 50, '完全有依据,部分有依据,无依据,未规划', '100,60,30,0', '业务规划', '业务目标', '', '', '管理层', '', '', '涉及钱的考核即可', '', NULL, NULL, NULL, '', 0),
	(8, 8, '配备二手车业务洽谈区?', 9, '是,否', '100,0', '业务规划', '基础配备', '', '', '管理层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(9, 9, '配备了评估检测专区？', 9, '均配备,静态检测配备,未配备', '100,50,0', '业务规划', '基础配备', '', '', '管理层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(10, 10, '配备了专用二手车销售展示场地？', 10, '是,否', '100,0', '业务规划', '基础配备', '', '', '管理层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(11, 11, '对二手车销售展示场地进行区域功能划分？', 8, '是,否', '100,0', '业务规划', '基础配备', '', '', '管理层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(12, 12, '二手车组织结构是否利于现阶段业务开展？', 10, '是,否', '100,0', '业务规划', '基础配备', '', '', '管理层', '', '', '组织结构图', '', NULL, NULL, NULL, '', 0),
	(13, 13, '是否配备了二手车经理', 9, '专职,兼职,未配备', '100,50,0', '业务规划', '基础配备', '', '', '管理层', '', '', '组织结构图', '', NULL, NULL, NULL, '', 0),
	(14, 14, '是否配备了评估师', 9, '专职,兼职,未配备', '100,50,0', '业务规划', '基础配备', '', '', '管理层', '', '', '组织结构图', '', NULL, NULL, NULL, '', 0),
	(15, 15, '是否配备了信息员', 9, '专职,兼职,未配备', '100,50,0', '业务规划', '基础配备', '', '', '管理层', '', '', '组织结构图', '', NULL, NULL, NULL, '', 0),
	(16, 16, '是否配备了二手车销售顾问', 9, '专职,兼职,未配备', '100,50,0', '业务规划', '基础配备', '', '', '管理层', '', '', '组织结构图', '', NULL, NULL, NULL, '', 0),
	(17, 17, '配备二手车部门人员办公设备?', 8, '是,否', '100,0', '业务规划', '基础配备', '', '', '管理层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(18, 18, '配备了二手车业务专项资金？', 10, '单店专项资金,单店占压新车款,集团资金,第三方垫资,无来源', '100,75,75,10,0', '业务规划', '基础配备', '', '', '管理层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(19, 19, '设置了二手车资金占压机制？', 11, '是,否', '100,0', '业务规划', '流程设计', '', '', '管理层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(20, 20, '设置了二手车财务审批流程？', 11, '专用审批工具审批,内部系统审批,旧车收销合同审批,新车销售单审批,无审批', '100,100,50,50,0', '业务规划', '流程设计', '', '', '管理层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(21, 21, '设置了二手车财务报表？', 6, '专项报表,纳入整体报表,有记录但无报表,无记录', '100,67,33,0', '业务规划', '流程设计', '', '', '管理层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(22, 22, '设置了置换业务流程?', 18, '有流程有工具,有流程无工具,无明确流程,完全无流程', '100,50,25,0', '业务规划', '流程设计', '', '', '管理层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(23, 23, '设置了置换业务管理报表?', 18, '含过程指标及台账报表,含过程指标报表,仅记录置换量报表,无报表', '100,67,33,0', '业务规划', '流程设计', '', '', '管理层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(24, 24, '设置了零售业务流程？', 18, '有流程有工具,有流程无工具,无明确流程,完全无流程', '100,50,25,0', '业务规划', '流程设计', '', '', '管理层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(25, 25, '设置了二手车业务管理报表?', 18, '含过程指标及台账报表,含过程指标报表,仅记录利润报表,无报表', '100,67,33,0', '业务规划', '流程设计', '', '', '管理层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(26, 26, '制定了年度/季度的收购量目标？', 10, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '业务目标文件', '', NULL, NULL, NULL, '', 0),
	(27, 27, '制定了年度/季度的销售量目标？（零售量、认证销售量）', 10, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '业务目标文件', '', NULL, NULL, NULL, '', 0),
	(28, 28, '设定了季度/月度新车部门的置换量目标？', 10, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(29, 29, '设定了季度/月度二手车部门的利润目标？（批售利润、零售利润、认证车利润、增值利润等）', 10, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(30, 30, '二手车经理根据收购进度进行了收购量目标调整？', 9, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '此项内容访谈询问是否对经营目标进行调整，能够有调整并说出依据即可', NULL, NULL, NULL, '', 0),
	(31, 31, '二手车经理根据销售进度进行了销售量目标调整？', 9, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '此项内容访谈询问是否对经营目标进行调整，能够有调整并说出依据即可', NULL, NULL, NULL, '', 0),
	(32, 32, '二手车经理根据基础目标，制定了人员配备规划？', 9, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(33, 33, '二手车经理根据基础目标，制定了库存管理规划？', 9, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(34, 34, '二手车经理根据基础目标，制定了资金运用规划？', 6, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(35, 35, '二手车经理根据销售目标，制定了收购渠道规划？', 6, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(36, 36, '二手车经理根据基础目标，制定了集客目标规划？', 6, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(37, 37, '二手车经理根据利润目标，制定了销售及衍生收入规划？', 6, '依据目标规划,未依据目标规划,未设定', '100,60,0', '业务运营', '目标分解', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(38, 38, '对新车销售部门设置了置换业务考核指标？（过程或结果指标均可）', 5, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '管理层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(39, 39, '对新车展厅管理人员设置了“评估量”、“置换量”考核指标？', 5, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(40, 40, '对新车销售顾问设置了“开口率”考核？', 5, '要求100%且有罚则,未要求100%且有罚则,有要求无罚则,无要求', '100,60,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(41, 41, '对新车销售顾问设置了有效“评估量”考核？', 5, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(42, 42, '对新车销售顾问设置了“置换量/率”考核？', 5, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(43, 43, '对二手车部门设置了“经营量”考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '管理层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(44, 44, '对二手车部门设置了“置换量/率”考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '管理层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(45, 45, '对二手车部门设置了“利润”考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '管理层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(46, 46, '对评估师或相关岗位设置了“评估成交率”考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(47, 47, '对评估师或相关岗位下达外采量/率的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(48, 48, '对评估师或相关岗位下达认证量/率的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(49, 49, '对评估师或相关岗位下达利润的考核？（毛利润/率、平均单车利润等）', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(50, 50, '对评估师或相关岗位下达整备费用差异率的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(51, 51, '对二手车销售顾问下达潜客留档量/率的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(52, 52, '对二手车销售顾问下达零售成交量/率的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(53, 53, '对二手车销售顾问下达认证销售量的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(54, 54, '对二手车销售顾问下达衍生产品的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(55, 55, '对二手车销售顾问下达客户满意度的考核？', 4, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(56, 56, '对整备师下达整备验收合格率的指标？', 2, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(57, 57, '对整备师下达整备按期交付率的考核？', 2, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(58, 58, '对信息员或相关岗位下达潜客邀约率的指标考核？', 3, '有具体数据有考核,有要求无具体数据无考核,无要求', '100,60,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '负责客户邀约的岗位均可', NULL, NULL, NULL, '', 0),
	(59, 59, '设置了置换业务激励政策？', 4, '是,否', '100,0', '业务运营', '绩效制定', '', '', '管理层', '', '', '绩效考核文件', '本条测评对象为管理层，零售或置换二者有其一即可；125条测评对象为运营层，重点为激励政策的落实', NULL, NULL, NULL, '', 0),
	(60, 60, '设置了全员激励政策？', 4, '是,否', '100,0', '业务运营', '绩效制定', '', '', '管理层', '', '', '绩效考核文件', '本条测评对象为管理层，零售或置换二者有其一即可；126条测评对象为运营层，重点为激励政策的落实', NULL, NULL, NULL, '', 0),
	(61, 61, '对二手车销售顾问设置了零售成交奖励机制？（单车奖励、利润比率提成等）', 4, '是,否', '100,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(62, 62, '对二手车销售顾问设置了认证车零售成交奖励机制？（单车奖励、利润比率提成等）', 4, '是,否', '100,0', '业务运营', '绩效制定', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(63, 63, '配有新车展厅流量登记工具？', 6, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(64, 64, '配有新车意向客户登记工具？', 6, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '无论是否使用，有就选“是”', NULL, NULL, NULL, '', 0),
	(65, 65, '配有置换潜客登记工具？', 6, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(66, 66, '配有车辆评估登记工具？', 7, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(67, 67, '配有收购审批工具？', 7, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(68, 68, '配有车辆定价参考工具？（拍卖平台、价格系统、历史库存记录、询价记录等）', 6, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(69, 69, '配有销售审批工具？', 7, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(70, 70, '配有二手车展厅流量登记工具？', 6, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(71, 71, '配有二手车客户洽谈卡？', 7, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '本项洽谈卡留档，73项报价单给客户，工具表单属性不同', NULL, NULL, NULL, '', 0),
	(72, 72, '配有渠道采购申请单？', 5, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(73, 73, '配有整备计划书、施工单？', 5, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(74, 74, '配有《二手车认证检测表》？', 5, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(75, 75, '配有二手车试乘试驾协议？', 5, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(76, 76, '配有二手车车辆钥匙登记工具？', 5, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(77, 77, '配有二手车销售报价单？', 7, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(78, 78, '配有二手车零售客户满意度调研工具？', 5, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(79, 79, '配有二手车客户投诉单？', 5, '是,否', '100,0', '业务运营', '流程制定', '', '', '运营层', '', '', '流程工具表单', '', NULL, NULL, NULL, '', 0),
	(80, 80, '统计了分车型置换率？', 8, '是,否', '100,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(81, 81, '新车展厅流量登记表中设计了再购客户信息登记条目？（区分到店/DCC）', 8, '是,否', '100,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '二级目录为信息系统，若店内有登记表但没做区分，功能不完善，选否', NULL, NULL, NULL, '', 0),
	(82, 82, '设置了客户信息管理表？（表头内容至少涵盖客户基本信息、联系方式、客户需求、客户级别、客户状态，缺一不可）', 12, '是,否', '100,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(83, 83, '设置了二手车业务进销存台账？（表头内容至少涵盖车辆信息、客户信息、交易信息、成本信息、利润信息，缺一不可）', 12, '是,否', '100,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(84, 84, '对渠道信息（特点、偏好车型等）进行汇总记录？', 8, '店内记录,个人记录,无记录', '100,60,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(85, 85, '对与渠道的历史交易情况进行记录？', 8, '店内记录,个人记录,无记录', '100,60,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(86, 86, '店内渠道是否满足当前业务需要？', 8, '满足,不满足,三方驻店,集团收购,无渠道', '100,50,0,0,0', '业务运营', '信息系统', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(87, 87, '定期开拓新渠道？', 6, '定期,依据需要,三方驻店,集团收购,无渠道', '100,60,0,0,0', '业务运营', '信息系统', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(88, 88, '设立了渠道合作标准？', 6, '有,三方驻店,集团收购,无', '100,0,0,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(89, 89, '与渠道签订了合作协议？', 6, '有,三方驻店,集团收购,无', '100,0,0,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(90, 90, '对渠道设立了竞价机制？', 6, '有,集团优先,三方驻店,集团直收,无', '100,100,0,0,0', '业务运营', '信息系统', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(91, 91, '建立车源采购渠道？（经纪公司、其他经销商、拍卖公司等）', 6, '是,否', '100,0', '业务运营', '信息系统', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(92, 92, '建立手续办理渠道？', 6, '是,否', '100,0', '业务运营', '信息系统', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(93, 93, '三个月内进行过置换业务全员培训？（各岗位均可）', 15, '有课件或其他证据,有培训无证据,无培训', '100,60,0', '业务运营', '业务管理', '', '', '运营层', '', '', '培训记录', '', NULL, NULL, NULL, '', 0),
	(94, 94, '新车销售部门晨夕会定期有置换专项话题？', 20, '是,否', '100,0', '业务运营', '业务管理', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(95, 95, '新车销售部门周度、月度例会有置换专项话题？', 20, '是,否', '100,0', '业务运营', '业务管理', '', '', '运营层', '', '', '会议记录', '', NULL, NULL, NULL, '', 0),
	(96, 96, '二手车人员参加新车销售部门周度、月度例会？', 15, '是,否', '100,0', '业务运营', '业务管理', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(97, 97, '总经理定期召开业务会议，涉及二手车业务内容？', 15, '是,否', '100,0', '业务运营', '业务管理', '', '', '管理层', '', '', '会议记录', '', NULL, NULL, NULL, '', 0),
	(98, 98, '二手车经理定期召部门开业务会议？', 15, '是,否', '100,0', '业务运营', '业务管理', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(99, 99, '建立成交客户档案？', 6, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '纸质/电子文档', '二级目录为业务监控，档案不齐全无法满足监控需求，不齐全视为无', NULL, NULL, NULL, '', 0),
	(100, 100, '置换评估量、置换量通报至销售总监/销售经理？', 8, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(101, 101, '总经理设置了二手车业务日、周、月报表制度？（有一项即可）', 8, '是,否', '100,0', '业务运营', '业务监控', '', '', '管理层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(102, 102, '对销售顾问的置换考核达成情况进行统计、分析和排名？', 6, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(103, 103, '对其他部门的置换达成情况进行统计、分析和排名？', 6, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(104, 104, '对置换推介开口率进行监控？（录音、回访）', 8, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(105, 105, '运营层对置换业务流程表单进行定期检查？', 7, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(106, 106, '运营层对二手车零售业务流程表单进行定期检查？', 7, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(107, 107, '运营层对战败原因进行分析？', 7, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(108, 108, '总经理要求定期反馈业务数据报表及分析结论\n（包括：销售部门置换潜客量（率）、评估邀约率、二手车部门评估成交率、置换率、收购数量、销售数量、毛利率、平均收购价格、平均销售价格、平均单车利润、平均库存时间）', 10, '分析全部数据,分析关键数据,不分析业务数据', '100,60,0', '业务运营', '业务监控', '', '', '管理层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(109, 109, '总经理要求定期反馈财务报表及分析结论\n（包括：置换率、收购数量、销售数量、毛利率、利润率、平均单车成本、平均利润率、平均库存时间）', 10, '分析全部数据,分析关键数据,不分析业务数据', '100,60,0', '业务运营', '业务监控', '', '', '管理层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(110, 110, '二手车经理定期了解业务各环节数据，并上报业务数据分析报告？', 7, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(111, 111, '客服部门的回访内容植入二手车话题？', 5, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '回访话术', '', NULL, NULL, NULL, '', 0),
	(112, 112, '二手车经理设置了部门内回访机制，并确立责任人？', 5, '是,否', '100,0', '业务运营', '业务监控', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(113, 113, '制定年度二手车营销规划？', 20, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(114, 114, '制定季度/月度二手车营销方案？（应涵盖时间、主题、目标、投放渠道、费用预算、配合部门、执行流程，缺一不可）', 20, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(115, 115, '进行了二手车营销方案成本核算?', 10, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(116, 116, '对营销效果进行分析与总结？', 10, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(117, 117, '是否结合市场情况对营销规划进行调整？', 10, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(118, 118, '三个月内曾包装过置换营销专项方案？', 10, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(119, 119, '三个月内曾针对基盘客户进行再购客户集客营销？', 10, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(120, 120, '三个月内曾针对常见置换车型客户进行再购客户集客营销？', 10, '是,否', '100,0', '业务推广', '设计能力', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(121, 121, '配备了置换业务全员营销奖励？', 50, '全员设置且执行,全员设置未执行,仅新车与售后部门,仅新车部门,无', '100,60,80,40,0', '业务推广', '全员营销', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(122, 122, '配备了二手车零售业务全员营销奖励？', 50, '全员设置且执行,全员设置未执行,仅新车与售后部门,仅新车部门,无', '100,60,80,40,0', '业务推广', '全员营销', '', '', '运营层', '', '', '绩效考核文件', '', NULL, NULL, NULL, '', 0),
	(123, 123, '新车展厅内部显著位置设有置换业务宣传品？（如：接待台、洽谈桌、展车等）', 20, '3个以上,2个,1个,无', '100,67,33,0', '业务推广', '展厅营销', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(124, 124, '新车展厅外部设有置换业务宣传品？（如：入口、展厅墙面、道旗等）', 20, '3个以上,2个,1个,无', '100,67,33,0', '业务推广', '展厅营销', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(125, 125, '售后接待区及客休区设有二手车业务宣传品？', 20, '3个以上,2个,1个,无', '100,67,33,0', '业务推广', '展厅营销', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(126, 126, '二手车展厅/展车设有二手车业务宣传品？', 20, '3个以上,2个,1个,无', '100,67,33,0', '业务推广', '展厅营销', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(127, 127, '宣传品标注了联络信息（联系人、联系电话）？', 20, '是,否', '100,0', '业务推广', '展厅营销', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(128, 128, '本季度参与了新车部门活动？', 30, '是,否', '100,0', '业务推广', '活动营销', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(129, 129, '本季度参与了其他部门活动？', 30, '是,否', '100,0', '业务推广', '活动营销', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(130, 130, '本季度开展了置换专项活动？（置换节、置换优惠等）', 20, '是,否', '100,0', '业务推广', '活动营销', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(131, 131, '本季度开展了二手车专项活动？（专项收购活动、专项销售活动等）', 20, '是,否', '100,0', '业务推广', '活动营销', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(132, 132, '应用新车销售网络推广中植入置换宣传内容？', 20, '是,否', '100,0', '业务推广', '媒体推广', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(133, 133, '应用微信等社交媒体进行再购客户集客？', 30, '是,否', '100,0', '业务推广', '媒体推广', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(134, 134, '应用其他方式进行再购客户集客营销？（电视，纸媒，户外等）', 20, '是,否', '100,0', '业务推广', '媒体推广', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(135, 135, '应用网络渠道发布车源求购信息？', 20, '是,否', '100,0', '业务推广', '媒体推广', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(136, 136, '店内制定自媒体营销机制？（区分组织行为与个人行为）', 20, '是,否', '100,0', '业务推广', '媒体推广', '', '', '运营层', '', '', '人员访谈', '此项内容通过人员访谈了解微信朋友圈公司是否要求全体转发', NULL, NULL, NULL, '', 0),
	(137, 137, '建立二手车网店？', 10, '是,否', '100,0', '业务推广', '媒体推广', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(138, 138, '应用至少2家网络推广渠道或网站，进行二手车零售集客推广？', 30, '是,否', '100,0', '业务推广', '媒体推广', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(139, 139, '对基盘客户开展二手车营销？（包含新车及二手车基盘客户）', 15, '是,否', '100,0', '业务推广', '基盘推广', '', '', '运营层', '', '', '营销记录', '', NULL, NULL, NULL, '', 0),
	(140, 140, '与第三方合作进行潜客信息采集，开展直复营销？（保险公司、驾校）', 10, '是,否', '100,0', '业务推广', '基盘推广', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(141, 141, '设置了二手车老客户转介绍奖励机制？', 25, '是,否', '100,0', '业务推广', '基盘推广', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(142, 142, 'DCC专员/新车销售顾问电话接待中主动提及置换购车方式？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(143, 143, 'DCC专员/新车销售顾问电话接待中对于再购客户是否邀约到店评估？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(144, 144, '新车销售顾问展厅接待中主动进行置换意向探寻与引导？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(145, 145, '新车销售顾问对置换业务与置换流程进行介绍？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(146, 146, '新车销售顾问了解最新的二手车政策？（国家政策、厂商政策）', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(147, 147, '新车销售顾问主动探寻客户信息与客户旧车信息？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(148, 148, '新车销售顾问主动探寻客户曾评估经历？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(149, 149, '新车销售顾问主动了解客户置换迫切程度与心理预期？', 5, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(150, 150, '新车销售顾问通过话术降低客户心理预期？', 5, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(151, 151, '新车销售顾问主动向评估师介绍客户信息及车辆信息？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(152, 152, '新车销售顾问郑重引荐评估师？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(153, 153, '新车销售顾问应用工具表单对潜客信息进行登记？', 3, '完善,不完善,无', '100,60,0', '业务执行', '车辆收购', '客户接待', '置换', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(154, 154, '新车销售顾问与评估师协同接待客户？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(155, 155, '评估师通过需求分析确定客户类型，推荐评估方式？（快速评估、标准评估）', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(156, 156, '评估师根据评估方式进行评估铺垫？（标准、花费时间等）', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(157, 157, '相关岗位人员邀请客户参与评估？', 3, '是,否', '100,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(158, 158, '评估前为客户清洗车辆？', 2, '是,否', '100,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(159, 159, '评估师执行合理的评估流程？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(160, 160, '评估师运用合理话术获取车辆情况、降低客户心理预期？', 5, '好,中,差', '100,60,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(161, 161, '评估师应用“评估表”记录评估信息？', 3, '完善,不完善,无', '100,60,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(162, 162, '评估师对车辆手续进行核查？', 4, '是,否', '100,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(163, 163, '提供上门评估服务？', 2, '是,否', '100,0', '业务执行', '车辆收购', '车辆评估', '置换', '执行层', '评估师', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(164, 164, '评估师与销售顾问沟通客户类型后制定报价决策？', 4, '是,否', '100,0', '业务执行', '车辆收购', '报价商谈', '置换', '执行层', '评估师', '商务谈判', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(165, 165, '评估师熟练掌握谈判技巧', 5, '好,中,差', '100,60,0', '业务执行', '车辆收购', '报价商谈', '置换', '执行层', '评估师', '商务谈判', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(166, 166, '新旧车部门建立了价格调剂机制？', 5, '是,否', '100,0', '业务执行', '车辆收购', '报价商谈', '置换', '运营层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(167, 167, '评估师应用二手车收购审批工具？', 3, '是,否', '100,0', '业务执行', '车辆收购', '车辆收购', '置换', '执行层', '评估师', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(168, 168, '评估师与成交客户签订《二手车收购协议》？', 3, '完善,不完善,无', '100,60,0', '业务执行', '车辆收购', '车辆收购', '置换', '执行层', '评估师', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(169, 169, '评估师与客户交接车辆及手续时，留存书面交接证明？', 4, '完善,不完善,无', '100,60,0', '业务执行', '车辆收购', '车辆收购', '置换', '执行层', '评估师', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(170, 170, '手续管理有序，安全性高，归档及时？', 3, '是,否', '100,0', '业务执行', '车辆收购', '车辆收购', '置换', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(171, 171, '进行了二手车客户回访', 5, '完善,不完善,无', '100,60,0', '业务执行', '车辆收购', '客户回访', '置换', '执行层', '评估师', '流程执行', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(172, 172, '评估师与新车销售顾问协同回访？', 5, '是,否', '100,0', '业务执行', '车辆收购', '客户回访', '置换', '执行层', '评估师', '流程执行', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(173, 173, '客户接待专员或相关岗位了解来电客户接待要点？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '直接收购', '', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(174, 174, '客户接待专员或相关岗位应用集客信息登记表单对收购潜客进行登记？', 3, '完善,不完善,无', '100,60,0', '业务执行', '车辆收购', '直接收购', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(175, 175, '客户接待专员或相关岗位对收购业务进行介绍？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '直接收购', '', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(176, 176, '客户接待专员或相关岗位郑重引荐评估师？', 3, '好,中,差', '100,60,0', '业务执行', '车辆收购', '直接收购', '', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(177, 177, '评估师探寻客户信息与客户旧车信息？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '直接收购', '', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(178, 178, '评估师探寻客户曾评估经历？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '直接收购', '', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(179, 179, '评估师了解客户售车迫切程度与心理预期？', 4, '好,中,差', '100,60,0', '业务执行', '车辆收购', '直接收购', '', '执行层', '评估师', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(180, 180, '二手车销售顾问根据潜客需求追加采购申请，填写渠道采购申请？', 3, '是,否', '100,0', '业务执行', '车辆收购', '渠道采购', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(181, 181, '二手车经理监控采购车辆与潜客需求匹配度，进行收购审批？', 3, '是,否', '100,0', '业务执行', '车辆收购', '渠道采购', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(182, 182, '评估师与渠道签订二手车收购协议？', 3, '完善,不完善,无', '100,60,0', '业务执行', '车辆收购', '渠道采购', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(183, 183, '评估师应用渠道车型信息记录工具记录渠道可提供车源信息？', 3, '是,否', '100,0', '业务执行', '车辆收购', '渠道采购', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(184, 184, '车辆零售时，评估师与二手车经理核算车辆预期维修整备成本后，出具二手车整备计划？', 8, '是,否', '100,0', '业务执行', '整备翻新', '', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(185, 185, '整备师按照《车辆上架展示标准》进行车辆整备翻新？', 8, '是,否', '100,0', '业务执行', '整备翻新', '', '', '执行层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(186, 186, '维修整备后，留存二手车整备计划？', 9, '完善,不完善,无', '100,60,0', '业务执行', '整备翻新', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(187, 187, '二手车人员熟悉车辆认证检测流程？', 8, '是,否', '100,0', '业务执行', '整备翻新', '', '', '执行层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(188, 188, '二手车人员熟悉车辆认证上报流程？', 8, '是,否', '100,0', '业务执行', '整备翻新', '', '', '执行层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(189, 189, '对所有认证车辆的申请材料进行存档？', 9, '完善,不完善,无', '100,60,0', '业务执行', '整备翻新', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(190, 190, '车辆零售时，二手车经理核算车辆预期库存周期与成本后，制定收购价格？', 8, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(191, 191, '制定钥匙使用规则，专人负责管理？', 6, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(192, 192, '对每辆展车设定了展示位置？', 8, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(193, 193, '根据客户需求进行增值配件安装？', 6, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(194, 194, '对库存车辆的收支平衡点进行分析？', 10, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(195, 195, '库存车辆符合《车辆展示标准》？', 8, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(196, 196, '根据展车类型，进行了合理展示分区？', 8, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '现场核实', '是：对展车进行特定展位设定，或有规律摆放展车；   否：随机摆放展车', NULL, NULL, NULL, '', 0),
	(197, 197, '已售车辆及时移到交车区？', 8, '是,否', '100,0', '业务执行', '车辆展示', '', '', '执行层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(198, 198, '定期对各展位的热度与集客量进行分析？', 8, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(199, 199, '对库存车辆定期进行清洁、维护？', 6, '是,否', '100,0', '业务执行', '车辆展示', '', '', '执行层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(200, 200, '展车价签清晰、准确、定期更新？', 8, '是,否', '100,0', '业务执行', '车辆展示', '', '', '执行层', '', '', '现场核实', '', NULL, NULL, NULL, '', 0),
	(201, 201, '根据库存时间制定阶段性营销策略？', 10, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(202, 202, '根据市场变化，适时调整库存结构规划？', 6, '是,否', '100,0', '业务执行', '车辆展示', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(203, 203, '车辆批售时，评估师应用工具对询价过程进行记录？', 5, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(204, 204, '车辆批售时，评估师应用二手车销售审批工具？', 5, '是,否', '100,0', '业务执行', '车辆销售', '', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(205, 205, '车辆批售时，评估师与成交渠道签订《二手车销售协议》？', 5, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(206, 206, '二手车咨询热线保持畅通，营业时间内随时有人接听？', 5, '是,否', '100,0', '业务执行', '车辆销售', '获取客户', '', '执行层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(207, 207, '客户接待专员或相关岗位应用集客信息登记表对销售潜客进行信息与需求登记？', 6, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '获取客户', '', '执行层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(208, 208, '二手车销售顾问在1天内对已登记的潜客进行回电邀约，并发送邀约短信？', 5, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '获取客户', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(209, 209, '到店客户在进店第一时间得到客户接待专员或相关岗位的有效接待？', 5, '是,否', '100,0', '业务执行', '车辆销售', '展厅接待', '', '执行层', '二手车销售顾问', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(210, 210, '二手车销售顾问接待时，携带工具包：二手车客户记录工具表、试乘试驾保证书、二手车销售协议、二手车过户委托书、促销资料与增值服务材料、欢迎卡、名片、计算器、清洁布？', 3, '是,否', '100,0', '业务执行', '车辆销售', '展厅接待', '', '执行层', '二手车销售顾问', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(211, 211, '二手车销售顾问配备产品库存清单，注明配置、库存天数与销售底价？', 3, '是,否', '100,0', '业务执行', '车辆销售', '展厅接待', '', '执行层', '二手车销售顾问', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(212, 212, '二手车销售顾问主动了解客户到店需求？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '展厅接待', '', '执行层', '二手车销售顾问', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(213, 213, '二手车销售顾问应用二手车客户记录工具表记录客户信息？', 6, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '展厅接待', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(214, 214, '客户离店时，确定客户联系方式、争取继续联络的机会，并邀约客户再次到店？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '展厅接待', '', '执行层', '二手车销售顾问', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(215, 215, '二手车销售顾问熟练掌握需求探寻与分析技巧？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '需求分析', '', '执行层', '二手车销售顾问', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(216, 216, '二手车销售顾问主动了解客户异议并通过话术有效打消客户疑虑？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '需求分析', '', '执行层', '二手车销售顾问', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(217, 217, '应用二手车客户记录工具表记录未成交客户的信息与需求？', 6, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '需求分析', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(218, 218, '二手车销售顾问按照车辆标准展示流程进行产品介绍？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '产品介绍', '', '执行层', '二手车销售顾问', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(219, 219, '二手车销售顾问了解所有产品的配置与特点并能够熟练介绍？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '产品介绍', '', '执行层', '二手车销售顾问', '产品知识', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(220, 220, '二手车销售顾问了解认证车的服务承诺并能够熟练介绍？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '产品介绍', '', '执行层', '二手车销售顾问', '产品知识', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(221, 221, '向客户充分介绍二手车服务内容？（使客户感到放心交易、契合需求、产品唯一、机会难得）', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '产品介绍', '', '执行层', '二手车销售顾问', '产品知识', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(222, 222, '二手车销售顾问了解车辆质保定义和相关条款？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '产品介绍', '', '执行层', '二手车销售顾问', '产品知识', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(223, 223, '二手车销售顾问结合客户需求，推荐适合的销售方案？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '报价商谈', '', '执行层', '二手车销售顾问', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(224, 224, '二手车销售顾问使用合理话术与客户交换成交条件？', 5, '好,中,差', '100,60,0', '业务执行', '车辆销售', '报价商谈', '', '执行层', '二手车销售顾问', '客户体验', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(225, 225, '设置了试乘试驾路线，可以满足各类试驾需求？', 3, '是,否', '100,0', '业务执行', '车辆销售', '试乘试驾', '', '运营层', '', '', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(226, 226, '核实客户证件并与客户签署试乘试驾协议？', 3, '是,否', '100,0', '业务执行', '车辆销售', '试乘试驾', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(227, 227, '向客户介绍试乘试驾路线与安全驾驶注意事项？', 3, '是,否', '100,0', '业务执行', '车辆销售', '试乘试驾', '', '执行层', '二手车销售顾问', '流程执行', '流程模拟', '', NULL, NULL, NULL, '', 0),
	(228, 228, '二手车销售顾问填写二手车销售审批工具，获取价格决策人审批？', 6, '是,否', '100,0', '业务执行', '车辆销售', '签约成交', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(229, 229, '二手车销售顾问与成交客户签订二手车销售协议？', 6, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '签约成交', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(230, 230, '二手车销售顾问与成交客户签订二手车过户委托书？', 5, '完善,不完善,无', '100,60,0', '业务执行', '车辆销售', '签约成交', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(231, 231, '应用二手车销售审批工具办理车辆出库？', 6, '是,否', '100,0', '业务执行', '车辆销售', '车辆交付', '', '执行层', '二手车销售顾问', '流程执行', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(232, 232, '进行车辆交付前检查？', 3, '是,否', '100,0', '业务执行', '车辆销售', '车辆交付', '', '执行层', '二手车销售顾问', '流程执行', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(233, 233, '应用车辆交付清单进行交付文件准备？', 3, '是,否', '100,0', '业务执行', '车辆销售', '车辆交付', '', '执行层', '二手车销售顾问', '流程执行', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(234, 234, '执行标准的交车流程？', 3, '是,否', '100,0', '业务执行', '车辆销售', '车辆交付', '', '执行层', '二手车销售顾问', '流程执行', '交车照片', '', NULL, NULL, NULL, '', 0),
	(235, 235, '应用客户回访信息记录工具表进行记录？', 10, '是,否', '100,0', '业务执行', '客户维系与开发', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(236, 236, '应用客户投诉信息记录表记录客户投诉？', 10, '是,否', '100,0', '业务执行', '客户维系与开发', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(237, 237, '应用满意度跟进工具表进行回访记录？', 10, '是,否', '100,0', '业务执行', '客户维系与开发', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0),
	(238, 238, '对客户投诉是否有处理流程和机制', 10, '是,否', '100,0', '业务执行', '客户维系与开发', '', '', '运营层', '', '', '人员访谈', '', NULL, NULL, NULL, '', 0),
	(239, 239, '定期进行投诉意见汇总与分析？', 10, '是,否', '100,0', '业务执行', '客户维系与开发', '', '', '运营层', '', '', '纸质/电子文档', '', NULL, NULL, NULL, '', 0);

