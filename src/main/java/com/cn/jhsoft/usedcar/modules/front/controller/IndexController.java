package com.cn.jhsoft.usedcar.modules.front.controller;

import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import com.cn.jhsoft.usedcar.modules.api.annotation.LoginUser;
import com.cn.jhsoft.usedcar.modules.api.entity.UserEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalQuestionEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalStageEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalQuestionService;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalResultService;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalStageService;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by chenyi9 on 2017/9/6.
 */
@Controller
public class IndexController extends AbstractController {

    @Autowired
    private EvalStageService evalStageService;
    @Autowired
    private EvalQuestionService evalQuestionService;
    @Autowired
    private EvalResultService evalResultService;

    /**
     * 后台
     */
    @AuthIgnore
    @GetMapping("/man")
    public void man(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/default.html");
    }

    /**
     * 首页
     */
    @AuthIgnore
    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/default.html");
    }

    /**
     * 报表
     */
    @AuthIgnore
    @GetMapping("/report")
    public String report(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        // 权限判断
        Subject subject = SecurityUtils.getSubject();
        // 有评测管理权限，能看所有人的
        // subject.isPermitted("pm:evalstage:manager")

        if (request.getParameter("n") != null && !"".equals(request.getParameter("n").toString())){
            EvalStageEntity entity = evalStageService.queryObjectByNum(request.getParameter("n").toString());
            if (entity != null){
                // 权限判断，自己的，或者管理者
                if (entity.getCreateAdminid() == getUserId() || subject.isPermitted("pm:evalstage:manager")){
                    model.addAttribute("obj", entity);
                    showPage(model, entity);
                }
            }
        }

        return "modules/front/index/report";
    }

    /**
     * 页面数据封装
     * @param model
     * @param entity
     */
    private void showPage(Model model, EvalStageEntity entity){
        Map<String, Object> params = new HashMap<>();
        params.put("stageNum", entity.getStageNum());
        params.put("categoryName", "category1");
        String[] categorys = new String[]{"业务规划", "业务运营", "业务推广", "业务执行"};

        List<EvalQuestionEntity> category1Lists = evalQuestionService.queryScoreListGroup(params);
        for(EvalQuestionEntity category1Entity : category1Lists){
            //category1Entity.setEvaluateWayScore(Math.round(Float.parseFloat(category1Entity.getEvaluateWayScore()))+"");

            // 最上方表格
            if (category1Entity.getCategory1().equals(categorys[0])) {
                model.addAttribute("category1_1", category1Entity);
            }else if (category1Entity.getCategory1().equals(categorys[1])) {
                model.addAttribute("category1_2", category1Entity);
            }else if (category1Entity.getCategory1().equals(categorys[2])) {
                model.addAttribute("category1_3", category1Entity);
            }else {
                model.addAttribute("category1_4", category1Entity);
            }
        }


        // 二级分类汇总
        params.put("stageNum", entity.getStageNum());
        params.put("categoryName", "category2");
        for (int i=0; i<categorys.length; i++) {
            params.put("searchStr", " where category1='"+categorys[i]+"'");
            List<EvalQuestionEntity> lists = evalQuestionService.queryScoreListGroup(params);
            EvalQuestionEntity _entity = new EvalQuestionEntity();
            int _fullScore = 0;
            int _myScore = 0;
            for (EvalQuestionEntity evalQuestionEntity : lists) {
                _fullScore += evalQuestionEntity.getFullScore();
                _myScore += Integer.valueOf(evalQuestionEntity.getEvaluateWayScore());
            }
            _entity.setCategory2("总分");
            _entity.setFullScore(_fullScore);
            _entity.setEvaluateWayScore(_myScore+"");
            lists.add(lists.size(), _entity);
            model.addAttribute("category2"+i+"Lists", lists);
        }

        // 置换与零售
        String[] businessStages = new String[]{"置换", "零售"};
        params.put("stageNum", entity.getStageNum());
        params.put("categoryName", "category3");
        for (int i=0; i<businessStages.length; i++) {
            params.put("stageAndtierWhere", "and business_stage = '"+businessStages[i]+"'");
            params.put("searchStr", " where business_stage = '"+businessStages[i]+"'");
            List<EvalQuestionEntity> lists = evalQuestionService.queryScoreListGroup(params);
            EvalQuestionEntity _entity = new EvalQuestionEntity();
            int _fullScore = 0;
            int _myScore = 0;
            for (EvalQuestionEntity evalQuestionEntity : lists) {
                _fullScore += evalQuestionEntity.getFullScore();
                _myScore += Integer.valueOf(evalQuestionEntity.getEvaluateWayScore());
            }
            _entity.setCategory3("总分");
            _entity.setFullScore(_fullScore);
            _entity.setEvaluateWayScore(_myScore+"");
            lists.add(lists.size(), _entity);
            model.addAttribute("category3"+i+"Lists", lists);
        }

        // 置换与零售
        String[] tiers = new String[]{"管理层", "运营层", "执行层"};
        params.put("stageNum", entity.getStageNum());
        for (int i=0; i<tiers.length; i++) {
            params.put("tier", tiers[i]);
            List<EvalQuestionEntity> lists = evalQuestionService.queryScoreList2Group(params);

            Set<String> category1Set = new LinkedHashSet<>();
            // 按一级分类来拆分
            for (EvalQuestionEntity evalQuestionEntity : lists) {
                category1Set.add(evalQuestionEntity.getCategory1());
            }
            Set<Map<String, List<EvalQuestionEntity>>> finalSet = new LinkedHashSet<>();
            for (String cate:category1Set){
                Map<String, List<EvalQuestionEntity>> _map = new HashMap<>();

                // 把本大分类下的小分类加入到临时list,作为value赋值给map
                List<EvalQuestionEntity> _lists = new LinkedList<>();
                for (EvalQuestionEntity evalQuestionEntity : lists){
                    if (evalQuestionEntity.getCategory1().equals(cate)){
                        _lists.add(evalQuestionEntity);
                    }
                }
                _map.put(cate, _lists);

                finalSet.add(_map);
            }
            model.addAttribute("category3"+i+"Sets", finalSet);
        }



    }

}
