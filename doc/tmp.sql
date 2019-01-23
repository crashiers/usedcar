-- SELECT * FROM tbl_eval_question where `category1` in (select name from tbl_basic_data where id = 8)

-- select a.num,b.answer from tbl_eval_question a left join tbl_eval_result b on a.num=b.question_num and b.stage_id is null and b.stage_num is null where num > 2  order by a.num asc

-- select count(*) from tbl_eval_result where question_num in (select num from tbl_eval_question where category1='业务规划') and stage_id is null
-- select count(*) from tbl_eval_result where create_adminid=1;
-- select sum(full_score) as full_score,category3,(select ROUND(sum(score)) from tbl_eval_result where question_num in (select num from tbl_eval_question where category3 = a.category3  and business_stage = '零售') and stage_num='120181222132212') as score from tbl_eval_question a where business_stage = '零售' group by category3;
-- select sum(score) from tbl_eval_result where question_num in (select num from tbl_eval_question where category3 = '报价商谈') and stage_num='120181222132212';
-- select num,full_score from tbl_eval_question where category3 = '报价商谈';


select category1,category2,sum(full_score) as full_score,(select ROUND(sum(score)) from tbl_eval_result where question_num in (select num from tbl_eval_question where category2 = a.category2 and tier='管理层') and stage_num='120181222132212') as score from tbl_eval_question a where tier='管理层' group by category1,category2


-- select * from tbl_eval_result where stage_num='120181222132212' and question_num in (164,165,166);

-- SELECT ROUND(-2.34),ROUND(-4.56),ROUND(2.34),ROUND(4.56);
-- select sum(full_score) as full_score,category2,(select ROUND(sum(score)) from tbl_eval_result where question_num in (select num from tbl_eval_question where category2 = a.category2) and stage_num='120181222132212') as score from tbl_eval_question a where category1='业务规划' group by category2;
select (@i:=@i+1) as i,sum(full_score) as full_score,(case @i when 0 then max(num)+3000 when 1 then max(num)+500 when 2 then max(num)+1000    else max(num)+1500 end) as num,category2,(select ROUND(sum(score)) from tbl_eval_result where question_num in (select num from tbl_eval_question where category2 = a.category2) and stage_num='120181222132212') as score from tbl_eval_question a,(select @i:=0) as it where category1='业务规划' group by category2 order by num desc;
-- select a.name,(select count(*) from tbl_eval_question where category1 = a.`name`) as qcount,(select count(*) from tbl_eval_result where question_num in (select num from tbl_eval_question where category1=a.name)) as acount from tbl_basic_data a where parent_id=4




update sys_menu set `order_num`=12 where `name`='经销商';
update sys_menu set `order_num`=13 where `name`='评测系统';
alter table tbl_eval_stage add `dealer_id` bigint DEFAULT 0 COMMENT '经销商ID' after `id`;
alter table tbl_eval_result add `dealer_id` bigint DEFAULT 0 COMMENT '经销商ID' after `stage_num`;
alter table tbl_eval_stage add `dealer_name` varchar(512) COMMENT '经销商名称' after `dealer_id`;
alter table tbl_dealer add `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID';
alter table tbl_dr add `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID';
alter table tbl_dra add `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID';
alter table tbl_drp add `create_adminid` bigint DEFAULT 0 COMMENT '添加人ID';

INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT (select menu_id from sys_menu where `name`='经销商'), '管理', null, 'pm:dealer:manager', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT (select menu_id from sys_menu where `name`='置换零售业务'), '管理', null, 'pm:dr:manager', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) SELECT (select menu_id from sys_menu where `name`='进销存'), '管理', null, 'pm:drp:manager', '2', null, '6';

drop table sys_log;
-- 系统日志
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COMMENT '用户名',
  `operation` varchar(50) COMMENT '用户操作',
  `method` varchar(200) COMMENT '请求方法',
  `params` varchar(5000) COMMENT '请求参数',
  `time` bigint NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) COMMENT 'IP地址',
  `create_date` datetime COMMENT '创建时间',
  `create_datetime` varchar(32) COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';


update tbl_basic_data set `name`='客户维系' where id=45;
update tbl_eval_question set `category2`='客户维系' where `category2`='客户维系与开发';
select id from tbl_basic_data where parent_id in (select id from tbl_basic_data where ename='brand');

