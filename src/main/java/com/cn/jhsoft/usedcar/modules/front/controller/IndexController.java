package com.cn.jhsoft.usedcar.modules.front.controller;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import com.cn.jhsoft.usedcar.modules.pm.entity.BasicDataEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.DraEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalQuestionEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.EvalStageEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.BasicDataService;
import com.cn.jhsoft.usedcar.modules.pm.service.DrService;
import com.cn.jhsoft.usedcar.modules.pm.service.DraService;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalQuestionService;
import com.cn.jhsoft.usedcar.modules.pm.service.EvalStageService;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
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
    private DrService drService;
    @Autowired
    private DraService draService;
    @Autowired
    private BasicDataService basicDataService;

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
    @GetMapping("/report")
    public String report(HttpServletRequest request, Model model) throws IOException {
        // 权限判断
        Subject subject = SecurityUtils.getSubject();
        // 有评测管理权限，能看所有人的
        // subject.isPermitted("pm:evalstage:manager")
        Set<String> numbers = new LinkedHashSet<>();

        if (request.getParameter("n") != null && !"".equals(request.getParameter("n").toString())){
            String[] nArray = request.getParameter("n").toString().split(",");
            EvalStageEntity entity;
            for(int i=0; i<nArray.length; i++){
                entity = evalStageService.queryObjectByNum(nArray[i]);
                // 存在 而且 有权限
                if (entity != null && (entity.getCreateAdminid() == getUserId() || subject.isPermitted("pm:evalstage:manager"))){
                    numbers.add(entity.getStageNum());
                    entity.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
                    if (i==0)
                        model.addAttribute("obj", entity);
                }
            }

            if (numbers.size() > 0)
                showPage(model, numbers);
        }

        Map<String, Object> params = new HashMap<>();
        params.put("n", request.getParameter("n"));
        params.put("token", request.getParameter("token"));
        model.addAttribute("params", params);
        model.addAttribute("numbersSize", numbers.size());

        return "modules/front/index/report";
    }

    /**
     * 页面数据封装
     * @param model
     * @param stageNums
     */
    private void showPage(Model model, Set<String> stageNums){

        Map<String, Object> params = new HashMap<>();
        int j = 1;
        for (String num : stageNums){
            params.put("stageNum" + ( j==1 ? "" : j ), num);
            j++;
        }
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
        params.put("categoryName", "category2");
        for (int i=0; i<categorys.length; i++) {
            params.put("searchStr", " where category1='"+categorys[i]+"'");
            List<EvalQuestionEntity> lists = evalQuestionService.queryScoreListGroup(params);
            EvalQuestionEntity _entity = new EvalQuestionEntity();
            int _fullScore = 0;
            int _myScore, _myScore2, _myScore3;
            _myScore = _myScore2 = _myScore3 = 0;
            for (EvalQuestionEntity evalQuestionEntity : lists) {
                _fullScore += evalQuestionEntity.getFullScore();
                _myScore += evalQuestionEntity.getEvaluateWayScore() == "" ? 0 : Integer.valueOf(evalQuestionEntity.getEvaluateWayScore());
                _myScore2 += evalQuestionEntity.getEvaluateWay() == "" ? 0 : Integer.valueOf(evalQuestionEntity.getEvaluateWay());
                _myScore3 += evalQuestionEntity.getRemark() == "" ? 0 : Integer.valueOf(evalQuestionEntity.getRemark());
            }
            _entity.setCategory2("总分");
            _entity.setFullScore(_fullScore);
            _entity.setEvaluateWayScore(_myScore+"");
            _entity.setEvaluateWay(_myScore2+"");
            _entity.setRemark(_myScore3+"");
            lists.add(lists.size(), _entity);
            model.addAttribute("category2"+i+"Lists", lists);
        }

        // 置换与零售
        String[] businessStages = new String[]{"置换", "零售"};
        params.put("categoryName", "category3");
        for (int i=0; i<businessStages.length; i++) {
            params.put("stageAndtierWhere", "and business_stage = '"+businessStages[i]+"'");
            params.put("searchStr", " where business_stage = '"+businessStages[i]+"'");
            List<EvalQuestionEntity> lists = evalQuestionService.queryScoreListGroup(params);
            EvalQuestionEntity _entity = new EvalQuestionEntity();
            int _fullScore = 0;
            int _myScore, _myScore2, _myScore3;
            _myScore = _myScore2 = _myScore3 = 0;
            for (EvalQuestionEntity evalQuestionEntity : lists) {
                _fullScore += evalQuestionEntity.getFullScore();
                _myScore += evalQuestionEntity.getEvaluateWayScore() == "" ? 0 : Integer.valueOf(evalQuestionEntity.getEvaluateWayScore());
                _myScore2 += evalQuestionEntity.getEvaluateWay() == "" ? 0 : Integer.valueOf(evalQuestionEntity.getEvaluateWay());
                _myScore3 += evalQuestionEntity.getRemark() == "" ? 0 : Integer.valueOf(evalQuestionEntity.getRemark());
            }
            _entity.setCategory3("总分");
            _entity.setFullScore(_fullScore);
            _entity.setEvaluateWayScore(_myScore+"");
            _entity.setEvaluateWay(_myScore2+"");
            _entity.setRemark(_myScore3+"");
            lists.add(lists.size(), _entity);
            model.addAttribute("category3"+i+"Lists", lists);
        }

        // 阶层
        String[] tiers = new String[]{"管理层", "运营层", "执行层"};
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




    /**
     * 雷达图
     */
    @GetMapping("/echarts")
    @ResponseBody
    public R echarts(@RequestParam Map<String, Object> params) throws IOException {
        // 权限判断
        Subject subject = SecurityUtils.getSubject();
        // 有评测管理权限，能看所有人的
        // subject.isPermitted("pm:evalstage:manager")
        Set<String> numbers = new LinkedHashSet<>();

        if (params.get("n") != null && !"".equals(params.get("n").toString())){
            String[] nArray = params.get("n").toString().split(",");
            EvalStageEntity entity;
            for(int i=0; i<nArray.length; i++){
                entity = evalStageService.queryObjectByNum(nArray[i]);
                // 存在 而且 有权限
                if (entity != null && (entity.getCreateAdminid() == getUserId() || subject.isPermitted("pm:evalstage:manager"))){
                    numbers.add(entity.getStageNum());
                }
            }
        }
        if (numbers.size() == 0){
            return R.error();
        }

        Map dataMap = new HashMap();
        Map<String, Object> _params = new HashMap<>();
        int j = 1;
        for (String num : numbers){
            _params.put("stageNum" + ( j==1 ? "" : j ), num);
            j++;
        }
        _params.put("categoryName", "category1");
        String[] categorys = new String[]{"业务规划", "业务运营", "业务推广", "业务执行"};
        List<EvalQuestionEntity> category1Lists = evalQuestionService.queryScoreListGroup(_params);

        // 输出给 雷达图 数据封装，返回两个List，List里都是Map。一个是每个角的名字和最大值。第二个是某一次测评征对第一个里每个角他的值。
        List<Map<String, Object>> resultIndicator1List = new LinkedList<>();
        List<Map<String, Object>> resultData1List = new LinkedList<>();
        Map<String, Object> _mapIndicator;
        Map<String, Object> _mapData;
        List<Integer> _valuesList1 = new LinkedList<>();
        List<Integer> _valuesList2 = new LinkedList<>();
        List<Integer> _valuesList3 = new LinkedList<>();
        for(EvalQuestionEntity category1Entity : category1Lists){
            _mapIndicator = new HashMap<>();
            _mapIndicator.put("name", category1Entity.getCategory1());
            _mapIndicator.put("max", category1Entity.getFullScore());
            resultIndicator1List.add(_mapIndicator);

            // 第一个评测的分数
            _valuesList1.add(category1Entity.getEvaluateWayScore().equals("") ? 0 : Integer.valueOf(category1Entity.getEvaluateWayScore()));
            // 第二个评测的分数
            _valuesList2.add(category1Entity.getEvaluateWay().equals("") ? 0 : Integer.valueOf(category1Entity.getEvaluateWay()));
            // 第三个评测的分数
            _valuesList3.add(category1Entity.getRemark().equals("") ? 0 : Integer.valueOf(category1Entity.getRemark()));
        }
        for (int k=1; k<=numbers.size(); k++){
            _mapData = new HashMap<>();
            _mapData.put("name", "评测"+ (numbers.size() > 1 ? k : ""));
            if (k == 1) _mapData.put("value", _valuesList1);
            if (k == 2) _mapData.put("value", _valuesList2);
            if (k == 3) _mapData.put("value", _valuesList3);
            resultData1List.add(_mapData);
        }
        dataMap.put("resultIndicator1List", resultIndicator1List);
        dataMap.put("resultData1List", resultData1List);

        // 二级分类汇总
        _params.put("categoryName", "category2");
        for (int i=0; i<categorys.length; i++) {
            _params.put("searchStr", " where category1='"+categorys[i]+"'");
            List<EvalQuestionEntity> lists = evalQuestionService.queryScoreListGroup(_params);

            // 输出给 雷达图 数据封装，返回两个List，List里都是Map。一个是每个角的名字和最大值。第二个是某一次测评征对第一个里每个角他的值。
            List<Map<String, Object>> resultIndicator2List = new LinkedList<>();
            List<Map<String, Object>> resultData2List = new LinkedList<>();
            Map<String, Object> _mapIndicator2;
            Map<String, Object> _mapData2;
            List<Integer> _valuesList21 = new LinkedList<>();
            List<Integer> _valuesList22 = new LinkedList<>();
            List<Integer> _valuesList23 = new LinkedList<>();
            for(EvalQuestionEntity _entity : lists){
                _mapIndicator2 = new HashMap<>();
                _mapIndicator2.put("name", _entity.getCategory2());
                _mapIndicator2.put("max", _entity.getFullScore());
                resultIndicator2List.add(_mapIndicator2);

                _valuesList21.add(_entity.getEvaluateWayScore().equals("") ? 0 : Integer.valueOf(_entity.getEvaluateWayScore()));
                _valuesList22.add(_entity.getEvaluateWay().equals("") ? 0 : Integer.valueOf(_entity.getEvaluateWay()));
                _valuesList23.add(_entity.getRemark().equals("") ? 0 : Integer.valueOf(_entity.getRemark()));
            }
            for (int k=1; k<=numbers.size(); k++){
                _mapData2 = new HashMap<>();
                _mapData2.put("name", "评测"+ (numbers.size() > 1 ? k : ""));
                if (k == 1) _mapData2.put("value", _valuesList21);
                if (k == 2) _mapData2.put("value", _valuesList22);
                if (k == 3) _mapData2.put("value", _valuesList23);
                resultData2List.add(_mapData2);
            }
            dataMap.put("resultIndicator2"+i+"List", resultIndicator2List);
            dataMap.put("resultData2"+i+"List", resultData2List);
        }

        // 置换与零售
        String[] businessStages = new String[]{"置换", "零售"};
        _params.put("categoryName", "category3");
        for (int i=0; i<businessStages.length; i++) {
            _params.put("stageAndtierWhere", "and business_stage = '"+businessStages[i]+"'");
            _params.put("searchStr", " where business_stage = '"+businessStages[i]+"'");
            List<EvalQuestionEntity> lists = evalQuestionService.queryScoreListGroup(_params);

            // 输出给 雷达图 数据封装，返回两个List，List里都是Map。一个是每个角的名字和最大值。第二个是某一次测评征对第一个里每个角他的值。
            List<Map<String, Object>> resultIndicator3List = new LinkedList<>();
            List<Map<String, Object>> resultData3List = new LinkedList<>();
            Map<String, Object> _mapIndicator3;
            Map<String, Object> _mapData3;
            List<Integer> _valuesList31 = new LinkedList<>();
            List<Integer> _valuesList32 = new LinkedList<>();
            List<Integer> _valuesList33 = new LinkedList<>();
            for(EvalQuestionEntity _entity : lists){
                _mapIndicator3 = new HashMap<>();
                _mapIndicator3.put("name", _entity.getCategory3());
                _mapIndicator3.put("max", _entity.getFullScore());
                resultIndicator3List.add(_mapIndicator3);

                _valuesList31.add(_entity.getEvaluateWayScore().equals("") ? 0 : Integer.valueOf(_entity.getEvaluateWayScore()));
                _valuesList32.add(_entity.getEvaluateWay().equals("") ? 0 : Integer.valueOf(_entity.getEvaluateWay()));
                _valuesList33.add(_entity.getRemark().equals("") ? 0 : Integer.valueOf(_entity.getRemark()));
            }
            for (int k=1; k<=numbers.size(); k++){
                _mapData3 = new HashMap<>();
                _mapData3.put("name", "评测"+ (numbers.size() > 1 ? k : ""));
                if (k == 1) _mapData3.put("value", _valuesList31);
                if (k == 2) _mapData3.put("value", _valuesList32);
                if (k == 3) _mapData3.put("value", _valuesList33);
                resultData3List.add(_mapData3);
            }
            dataMap.put("resultIndicator3"+i+"List", resultIndicator3List);
            dataMap.put("resultData3"+i+"List", resultData3List);
        }

        return R.ok().put("thisData", dataMap);
    }

    /**
     * 置换业务看板
     */
    @GetMapping("/board")
    public String board(HttpServletRequest request, Model model) throws IOException {

        Map<String, Object> params = new HashMap<>();
        params.put("d", request.getParameter("d"));
        params.put("b", request.getParameter("b"));
        params.put("token", request.getParameter("token"));
        model.addAttribute("params", params);

        // 权限判断
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isPermitted("pm:dr:list")){
            return "modules/front/index/board";
        }

        // 取出车型
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", params.get("b"));
        List<BasicDataEntity> basicDataList = basicDataService.queryList(map);

        // 取出销售和置换台次
        // 总数

        // 新车
        map.put("atype", 1);
        map.put("brand", params.get("b"));
        map.put("dealerId", params.get("d"));
        List<DraEntity> draLists1 = draService.queryListGroupArctic(map);
        Map<String, Integer> draAmounts1 = new HashMap<>();
        for (DraEntity draEntity : draLists1){
            draAmounts1.put(draEntity.getArctic(), draEntity.getAmount());
        }

        // 置换
        map.put("atype", 2);
        List<DraEntity> draLists2 = draService.queryListGroupArctic(map);
        Map<String, Integer> draAmounts2 = new HashMap<>();
        for (DraEntity draEntity : draLists2){
            draAmounts2.put(draEntity.getArctic(), draEntity.getAmount());
        }

        List<Map<String, Object>> lists = new LinkedList<>();
        Map<String, Object> _map;
        int d1 = 0;
        float d2 = 0;
        int d3 = 0;
        float d4 = 0;
        DecimalFormat df = new DecimalFormat("#.#");//格式化小数

        for (BasicDataEntity bdEntity : basicDataList){
            _map = new HashMap<>();
            _map.put("title", bdEntity.getName());
            _map.put("draAmount1", draAmounts1.get(bdEntity.getId()+"") == null ? "0" : draAmounts1.get(bdEntity.getId()+""));
            _map.put("draAmount2", draAmounts2.get(bdEntity.getId()+"") == null ? "0" : draAmounts2.get(bdEntity.getId()+""));
            lists.add(_map);
            d1 += Integer.valueOf(_map.get("draAmount1").toString());
            d3 += Integer.valueOf(_map.get("draAmount2").toString());
        }

        for (Map<String, Object> m : lists){
            m.put("draAmountBi1", 0);
            if (d1 != 0){
                float _bi = Float.valueOf(m.get("draAmount1").toString()) / d1;
                d2 += _bi;
                m.put("draAmountBi1", df.format(_bi*100));
            }

            m.put("draAmountBi2", 0);
            if (Integer.valueOf(m.get("draAmount1").toString()) != 0){
                float _bi = Float.valueOf(m.get("draAmount2").toString()) / Integer.valueOf(m.get("draAmount1").toString());
                m.put("draAmountBi2", df.format(_bi*100));
            }
        }
        if (d1 > 0) {
            d4 = ((float)d3 / d1) * 100;
        }
        if (d2 > 1){
            d2 = 1;
        }

        // 添加总数
        _map = new HashMap<>();
        _map.put("title", "总计");
        _map.put("draAmount1", d1);
        _map.put("draAmountBi1", df.format(d2*100));
        _map.put("draAmount2", d3);
        _map.put("draAmountBi2", df.format(d4));
        lists.add(_map);

        model.addAttribute("createDatetime", DateUtils.getTodayDateYMDHMS());
        model.addAttribute("boardLists", lists);
        return "modules/front/index/board";

    }




    /**
     * 饼状图
     */
    @GetMapping("/boardecharts")
    @ResponseBody
    public R boardEcharts(@RequestParam Map<String, Object> params) throws IOException {
        // 权限判断
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isPermitted("pm:dr:list")){
            return R.error();
        }
        DecimalFormat df = new DecimalFormat("#.#");//格式化小数

        // 取出车型
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", params.get("b"));
        List<BasicDataEntity> basicDataList = basicDataService.queryList(map);

        // 新车
        map.put("atype", 1);
        map.put("brand", params.get("b"));
        map.put("dealerId", params.get("d"));
        List<DraEntity> draLists1 = draService.queryListGroupArctic(map);
        Map<String, Integer> draAmounts = new HashMap<>();
        int allAmount = 0;
        for (DraEntity draEntity : draLists1){
            draAmounts.put(draEntity.getArctic(), draEntity.getAmount());
            allAmount += draEntity.getAmount();
        }

        List<String> titles = new LinkedList<>();
        List<Map<String, Object>> datas = new LinkedList<>();
        for (BasicDataEntity entity : basicDataList){
            Map<String, Object> m = new LinkedHashMap<>();
            if (draAmounts.get(entity.getId()+"") == null){
                m.put("value", 0);
            }else {
                //m.put("value", df.format(((float) draAmounts.get(entity.getId()+"") / allAmount) * 100));
                m.put("value", draAmounts.get(entity.getId()+""));
            }
            m.put("name", entity.getName());
            datas.add(m);

            titles.add(entity.getName());
        }


        Map resultMap = new HashMap();
        resultMap.put("titles", titles);
        resultMap.put("datas", datas);

        return R.ok().put("thisData", resultMap);
    }




}
