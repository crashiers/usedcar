package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.util.*;

import com.cn.jhsoft.usedcar.common.annotation.SysLog;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalQuestionEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalStageEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalQuestionService;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalStageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.EvalResultEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalResultService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.IPUtils;



/**
 * 评测结果
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-21 16:28:52
 */
@RestController
@RequestMapping("/pm/evalresult")
public class EvalResultController extends AbstractController {
	@Autowired
	private EvalResultService evalResultService;
	@Autowired
	private EvalQuestionService evalQuestionService;
	@Autowired
	private EvalStageService evalStageService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:evalresult:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EvalResultEntity> evalResultList = evalResultService.queryList(query);
		int total = evalResultService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(evalResultList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:evalresult:info")
	public R info(@PathVariable("id") Long id){
		EvalResultEntity evalResult = evalResultService.queryObject(id);
		
		return R.ok().put("evalResult", evalResult);
	}

	/**
	 * 回答每一题时，ajax 保存入库
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:evalstage:used")
	public R save(Integer rn,
				  String an,
				  Long dealerId){

		if (rn == null || rn <= 0){
			return R.error();
		}
		if (dealerId == null || dealerId <= 0){
			return R.error();
		}
		EvalQuestionEntity evalQuestion = evalQuestionService.queryObjectByNum(rn);
		if (evalQuestion == null){
			return R.error();
		}

		// 查询是否存在
		boolean isExist = true;
		Map params = new HashMap<>();
		params.put("createAdminid", getUserId());
		params.put("questionNum", rn);
		params.put("dealerId", dealerId);
		EvalResultEntity evalResult = evalResultService.queryObjectByRn(params);
		if(evalResult == null){
			evalResult = new EvalResultEntity();
			isExist = false;
		}


		String[] answers = evalQuestion.getEvaluateWay().split(",");
		String[] scores = evalQuestion.getEvaluateWayScore().split(",");
		Float answerScore = 0f;
		try {
			for (int i = 0; i < answers.length; i++) {
				if (answers[i].equals(an)) {
					answerScore = Float.parseFloat(scores[i]);
					continue;
				}
			}
		}catch (Exception ex){}

		evalResult.setQuestionNum(rn.intValue());
		evalResult.setAnswer(an);
		evalResult.setFullScore(evalQuestion.getFullScore());
		evalResult.setAnswerScore(answerScore);
		// 根据满分和答案分比例计算最后得分
		evalResult.setScore(evalQuestion.getFullScore() * answerScore / 100);

        evalResult.setCreateTime(DateUtils.getTimeStamp());
        evalResult.setCreateAdminid(getUserId());
        evalResult.setCreateDate(DateUtils.getTodayDate());
        evalResult.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
        evalResult.setCreatedip(IPUtils.getIpAddr());
        evalResult.setDealerId(dealerId);

        if (!isExist) {
			evalResultService.save(evalResult);
		}else{
        	evalResultService.update(evalResult);
		}
		
		return R.ok();
	}
	
	/**
	 * 提交评测
	 */
	@SysLog("提交评测")
	@RequestMapping("/update")
	@RequiresPermissions("pm:evalstage:used")
	public R update(Long dealerId){

        // 是否已完成所有答题
		Map<String, Object> evalMap = new HashMap<>();
		evalMap.put("createAdminid", getUserId());
		// 题目数量
		int questionSum = evalQuestionService.queryTotal2(evalMap);
		// 已答数量
		evalMap.put("dealerId", dealerId);
		int answeredSum = evalResultService.queryTotal2(evalMap);

		if (questionSum > answeredSum){
			return R.error("请您回答完所有题目再提交！分类上红色圆圈代表未答题目数量。");
		}

		// 在批次中创建批次
		EvalStageEntity evalStageEntity = new EvalStageEntity();
		evalStageEntity.setCreateAdminid(getUserId());
		evalStageEntity.setCreateAdmin(getUser().getRelname());
		evalStageEntity.setCreateDate(DateUtils.getTodayDate());
		evalStageEntity.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		evalStageEntity.setStageNum(getUserId() + DateUtils.format(new Date(), "yyyyMMddHHmmss"));
		evalStageEntity.setDealerId(dealerId);
		evalStageService.save(evalStageEntity);

		evalMap.put("stageNull", "yes");
		List<EvalResultEntity> lists = evalResultService.queryList(evalMap);
		EvalQuestionEntity evalQuestionEntity;
		float score1, score2, score3, score4, score5, score6, score7, score8, score9;
		score1 = score2 = score3 = score4 = score5 = score6 = score7 = score8 = score9 = 0;
		for (EvalResultEntity entity : lists){
			entity.setStageId(evalStageEntity.getId());
			entity.setStageNum(evalStageEntity.getStageNum());
			evalResultService.update(entity);

			// 按类别查分
			evalQuestionEntity = evalQuestionService.queryObjectByNum(entity.getQuestionNum());
			if (evalQuestionEntity == null){
				continue;
			}
			if (evalQuestionEntity.getCategory1().equals("业务规划")){
				score1 += entity.getScore();
			}
			if (evalQuestionEntity.getCategory1().equals("业务运营")){
				score2 += entity.getScore();
			}
			if (evalQuestionEntity.getCategory1().equals("业务推广")){
				score3 += entity.getScore();
			}
			if (evalQuestionEntity.getCategory1().equals("业务执行")){
				score4 += entity.getScore();
			}
			if (evalQuestionEntity.getBusinessStage().equals("置换")){
				score5 += entity.getScore();
			}
			if (evalQuestionEntity.getBusinessStage().equals("零售")){
				score6 += entity.getScore();
			}
			if (evalQuestionEntity.getTier().equals("管理层")){
				score7 += entity.getScore();
			}
			if (evalQuestionEntity.getTier().equals("运营层")){
				score8 += entity.getScore();
			}
			if (evalQuestionEntity.getTier().equals("执行层")){
				score9 += entity.getScore();
			}
		}

		// 更新批次
		evalStageEntity.setScore1(score1);
		evalStageEntity.setScore2(score2);
		evalStageEntity.setScore3(score3);
		evalStageEntity.setScore4(score4);
		evalStageEntity.setScore5(score5);
		evalStageEntity.setScore6(score6);
		evalStageEntity.setScore7(score7);
		evalStageEntity.setScore8(score8);
		evalStageEntity.setScore9(score9);

		evalStageService.update(evalStageEntity);

		return R.ok();
	}

	/**
	 * 机器人自动提交评测
	 */
	@SysLog("机器人自动提交评测")
	@RequestMapping("/auto")
	@RequiresPermissions("pm:evalstage:evaljqr")
	public R autoEval(Long dealerId){

		// 在批次中创建批次
		EvalStageEntity evalStageEntity = new EvalStageEntity();
		evalStageEntity.setCreateAdminid(getUserId());
		evalStageEntity.setCreateAdmin(getUser().getRelname());
		evalStageEntity.setCreateDate(DateUtils.getTodayDate());
		evalStageEntity.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		evalStageEntity.setStageNum(getUserId() + DateUtils.format(new Date(), "yyyyMMddHHmmss"));
		evalStageEntity.setDealerId(dealerId);
		evalStageService.save(evalStageEntity);

		Map<String, Object> params = new HashMap<>();
		List<EvalQuestionEntity> lists = evalQuestionService.queryList(params);
		EvalResultEntity evalResult;
		float score1, score2, score3, score4, score5, score6, score7, score8, score9;
		score1 = score2 = score3 = score4 = score5 = score6 = score7 = score8 = score9 = 0;
		for (EvalQuestionEntity evalQuestion : lists){


			String[] answers = evalQuestion.getEvaluateWay().split(",");
			String[] scores = evalQuestion.getEvaluateWayScore().split(",");
			Float answerScore = 0f;
			// 随机选择一个答案
			int randomNumber = new Random().nextInt(answers.length);
			String an = answers[randomNumber];
			try {
				answerScore = Float.parseFloat(scores[randomNumber]);
			}catch (Exception ex){}

			evalResult = new EvalResultEntity();
			evalResult.setQuestionNum(evalQuestion.getNum());
			evalResult.setAnswer(an);
			evalResult.setFullScore(evalQuestion.getFullScore());
			evalResult.setAnswerScore(answerScore);
			// 根据满分和答案分比例计算最后得分
			evalResult.setScore(evalQuestion.getFullScore() * answerScore / 100);
			evalResult.setCreateTime(DateUtils.getTimeStamp());
			evalResult.setCreateAdminid(getUserId());
			evalResult.setCreateDate(DateUtils.getTodayDate());
			evalResult.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
			evalResult.setCreatedip(IPUtils.getIpAddr());
			evalResult.setStageId(evalStageEntity.getId());
			evalResult.setStageNum(evalStageEntity.getStageNum());
			evalResult.setDealerId(dealerId);
			evalResultService.save(evalResult);

			// 按类别查分
			if (evalQuestion.getCategory1().equals("业务规划")){
				score1 += evalResult.getScore();
			}
			if (evalQuestion.getCategory1().equals("业务运营")){
				score2 += evalResult.getScore();
			}
			if (evalQuestion.getCategory1().equals("业务推广")){
				score3 += evalResult.getScore();
			}
			if (evalQuestion.getCategory1().equals("业务执行")){
				score4 += evalResult.getScore();
			}
			if (evalQuestion.getBusinessStage().equals("置换")){
				score5 += evalResult.getScore();
			}
			if (evalQuestion.getBusinessStage().equals("零售")){
				score6 += evalResult.getScore();
			}
			if (evalQuestion.getTier().equals("管理层")){
				score7 += evalResult.getScore();
			}
			if (evalQuestion.getTier().equals("运营层")){
				score8 += evalResult.getScore();
			}
			if (evalQuestion.getTier().equals("执行层")){
				score9 += evalResult.getScore();
			}
		}

		// 更新批次
		evalStageEntity.setScore1(score1);
		evalStageEntity.setScore2(score2);
		evalStageEntity.setScore3(score3);
		evalStageEntity.setScore4(score4);
		evalStageEntity.setScore5(score5);
		evalStageEntity.setScore6(score6);
		evalStageEntity.setScore7(score7);
		evalStageEntity.setScore8(score8);
		evalStageEntity.setScore9(score9);

		evalStageService.update(evalStageEntity);

		return R.ok();
	}




	/**
	 * 导入上次所答的所有题
	 */
	@SysLog("导入上次所答的所有题")
	@RequestMapping("/importlasteval")
	@RequiresPermissions("pm:evalstage:used")
	public R importLastEval(Long dealerId,
				  String category1,
				  String category2,
				  String category3){

		if (dealerId == null || dealerId <= 0){
			return R.error("参数不正确");
		}

		Map<String, Object> _params = new HashMap<>();
		_params.put("dealerId", dealerId);
		_params.put("createAdminid", getUserId());
		Query query = new Query(_params);
		query.setLimit(1);
		List<EvalStageEntity> evalStageList = evalStageService.queryList(query);
		EvalStageEntity evalStage = evalStageList.size() > 0 ? evalStageList.get(0) : null;

		if (evalStage == null){
			return R.error("不存在上次的评测记录");
		}

		// 遍历上次的评测记录
		_params.clear();
		_params.put("stageNum", evalStage.getStageNum());
		_params.put("Category1Id", category1);
		_params.put("Category2Id", category2);
		_params.put("Category3Id", category3);
		List<EvalResultEntity> resultLists = evalResultService.queryList3(_params);
		for (EvalResultEntity resultEntity : resultLists){
			Integer rn = resultEntity.getQuestionNum();
			String an = resultEntity.getAnswer();
			EvalQuestionEntity evalQuestion = evalQuestionService.queryObjectByNum(rn);

			// 查询是否存在
			boolean isExist = true;
			Map params = new HashMap<>();
			params.put("createAdminid", getUserId());
			params.put("questionNum", rn);
			params.put("dealerId", dealerId);
			EvalResultEntity evalResult = evalResultService.queryObjectByRn(params);
			if(evalResult == null){
				evalResult = new EvalResultEntity();
				isExist = false;
			}

			evalResult.setQuestionNum(resultEntity.getQuestionNum());
			evalResult.setAnswer(resultEntity.getAnswer());
			evalResult.setFullScore(resultEntity.getFullScore());
			evalResult.setAnswerScore(resultEntity.getAnswerScore());
			// 根据满分和答案分比例计算最后得分
			evalResult.setScore(resultEntity.getScore());

			evalResult.setCreateTime(DateUtils.getTimeStamp());
			evalResult.setCreateAdminid(getUserId());
			evalResult.setCreateDate(DateUtils.getTodayDate());
			evalResult.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
			evalResult.setCreatedip(IPUtils.getIpAddr());
			evalResult.setDealerId(dealerId);

			if (!isExist) {
				evalResultService.save(evalResult);
			}else{
				evalResultService.update(evalResult);
			}

		}

		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:evalresult:delete")
	public R delete(@RequestBody Long[] ids){
		evalResultService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
