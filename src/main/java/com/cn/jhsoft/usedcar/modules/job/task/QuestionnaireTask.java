package com.cn.jhsoft.usedcar.modules.job.task;

import com.cn.jhsoft.usedcar.modules.pm.entity.ScoreCountEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.AHPComputeWeight;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveDataService;
import com.cn.jhsoft.usedcar.modules.pm.service.ApproveWeightMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyongdong on 2018/5/16.
 */
@Component("QuestionnaireTask")
public class QuestionnaireTask {
    @Autowired
    private ApproveDataService approveDataService;

    @Autowired
    private ApproveWeightMatrixService approveWeightMatrixService;

    /*
    初始化小类id
    {{1, 2, 3, 4}, {5, 6, 7, 8, 9, 10, 11}, {12, 13, 14, 15, 16, 17}, {18, 19, 20}, {21, 22, 23}, {102, 103, 104, 105, 106}}
    */
    private int[] expectation = new int[]{1, 2, 3, 4};  //客户期望
    private int[] quality = new int[]{5, 6, 7, 8, 9, 10, 11};   //感知质量
    private int[] value = new int[]{12, 13, 14, 15, 16, 17};    //感知价值
    private int[] complaint = new int[]{18, 19, 20};    //客户投诉
    private int[] loyalty = new int[]{21, 22, 23};  //客户忠诚度
    private int[] criterion = new int[]{102, 103, 104, 105, 106};   //准则层指标

    private Map<String, int[]> smallCategoryMap = new HashMap<String, int[]>() {
        {
            put("expectation", expectation);
            put("quality", quality);
            put("value", value);
            put("complaint", complaint);
            put("loyalty", loyalty);
            put("criterion", criterion);
        }
    };

    /*
    初始化大类id
     */
    private Map<String, Integer> bigCategoryMap = new HashMap<String, Integer>() {
        {
            put("expectation", 2);
            put("quality", 3);
            put("value", 4);
            put("complaint", 5);
            put("loyalty", 6);
            put("criterion", 1);
        }
    };

    /*
    初始化权重
     */
    private Map<String, double[]> weightMap = new HashMap<String, double[]>() {
        {
            put("expectation", new double[]{});
            put("quality", new double[]{});
            put("value", new double[]{});
            put("complaint", new double[]{});
            put("loyalty", new double[]{});
            put("criterion", new double[]{});
        }
    };

    /*
    遍历categoryMap，查询权重数据并计算所有类的权重
     */
    private void computeWeightList() {

        for (String categoryKey : smallCategoryMap.keySet()) {
            System.out.println(categoryKey);
            int[] value = smallCategoryMap.get(categoryKey);
            int N = value.length;

            Double[][] weightListDD = new Double[N][N];

            for (int i = 0; i < N; i++) {
                int smallCategoryY = value[i];
                List<String> weightListS = approveWeightMatrixService.queryWeightListBySmallCategoryY(smallCategoryY);
                Double[] weightListD = new Double[N];
                for (int ii = 0; ii < weightListS.size(); ii++) {
                    String[] ss = weightListS.get(ii).split("/");
                    /*
                    以"/"为分隔符拆分字符串，如果长度为2取两值的除数，如果长度为1直接赋值
                     */
                    if (ss.length == 2) {
                        double d = Double.parseDouble(ss[0]) / Double.parseDouble(ss[1]);
                        weightListD[ii] = d;
                    } else {
                        double d = Double.parseDouble(ss[0]);
                        weightListD[ii] = d;
                    }
                }
                weightListDD[i] = weightListD;

            }
            AHPComputeWeight ahpComputeWeight = new AHPComputeWeight(weightListDD, 10);
            Map<String, Object> result = ahpComputeWeight.calculate();
            double[] weight = (double[]) result.get("weight");
            weightMap.put(categoryKey, weight); //给对应的大类重新赋计算的权重值

            System.out.println("权重向量:");
            for (double i : weight) {
                System.out.print(i + " ");
                System.out.println();
            }
        }


    }

    private void computeScore() {
        /*
        初始化类别分数，每个类别包含5个元素，对应5个分数
         */
        Map<String, double[]> scoreMap = new HashMap<String, double[]>() {
            {
                put("expectation", new double[]{0, 0, 0, 0, 0});
                put("quality", new double[]{0, 0, 0, 0, 0});
                put("value", new double[]{0, 0, 0, 0, 0});
                put("complaint", new double[]{0, 0, 0, 0, 0});
                put("loyalty", new double[]{0, 0, 0, 0, 0});
                put("criterion", new double[]{0, 0, 0, 0, 0});
            }
        };

        /*
        计算非"criterion"所有小类的分数数组，所有数组都是5个元素
         */
        for (String categoryKey : smallCategoryMap.keySet()) {
            if (!categoryKey.equals("criterion")) {
                //System.out.println("cate name: " + categoryKey);

                int[] value = smallCategoryMap.get(categoryKey); //获取小类id数组
                int N = value.length;

                double[] smallWeightList = weightMap.get(categoryKey);  //获取小类权重数组


                for (int i = 0; i < N; i++) {
                    int smallCategory = value[i];
                    //System.out.println("smallCategory: " + smallCategory);
                    List<ScoreCountEntity> scoreCountLists = approveDataService.queryScoreCountListBySmallCategory(smallCategory);
                    //System.out.println(scoreCountLists);
                    int questionNum = approveDataService.queryQuestionCountBySmallCategory(smallCategory);
                    //System.out.println("que num: " + questionNum);

                    double smallWeight = smallWeightList[i];    //获取对应小类的权重

                    for (ScoreCountEntity scoreCount : scoreCountLists) {
                        int score = scoreCount.getScore();  //获取分数
                        int num = scoreCount.getNum();  //获取分数个数

                        double v = ((double) num / questionNum) * smallWeight;    //小类分数占比与权重相乘
                        //System.out.println(score + " score * weight: " + v);
                        scoreMap.get(categoryKey)[score - 1] += v;  //数值保存到对应的位置 1分->a[0]
                        //System.out.println(score + " score total: " + scoreMap.get(categoryKey)[ii]);
                    }
                }
            }
        }

        /*
        计算"criterion"分数
         */
        double[] criterionWeightList = weightMap.get("criterion");  //获取准则层权重
        double[] criterionScoreList = scoreMap.get("criterion");
        int scoreNum = criterionScoreList.length;

        for (String categoryKey : bigCategoryMap.keySet()) {
            if (!categoryKey.equals("criterion")) {
                int bigID = bigCategoryMap.get(categoryKey);    //获取大类id
                double criterionWeight = criterionWeightList[bigID - 2];    //获取大类权重

                for (int i = 0; i < scoreNum; i++) {
                    double v = scoreMap.get(categoryKey)[i] * criterionWeight;  //大类5个元素分别与权重相乘
                    //System.out.println(i + " score * weight: " + v);
                    criterionScoreList[i] += v;
                    //System.out.println(i + " score total: " + criterionScoreList[i]);
                }
            }
        }

        /*
        根据数组计算总分
         */
        double totalScore = 0;
        for (int i = 0; i < scoreNum; i++) {
            totalScore += criterionScoreList[i] * (i + 1) * 20; //数组5个元素分别与[20,40,60,80,100]对应相乘，然后求和
        }
        System.out.println(totalScore);
    }

    public void run() {
        computeWeightList();
        computeScore();
    }

}
