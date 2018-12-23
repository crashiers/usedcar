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
-- select a.name,(select count(*) from tbl_eval_question where category1 = a.`name`) as qcount,(select count(*) from tbl_eval_result where question_num in (select num from tbl_eval_question where category1=a.name)) as acount from tbl_basic_data a where parent_id=4