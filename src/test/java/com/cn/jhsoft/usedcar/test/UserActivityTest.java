package com.cn.jhsoft.usedcar.test;

import com.cn.jhsoft.usedcar.MyApplication;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by liuyongdong on 2018/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class UserActivityTest {
    public static final Gson gson = new Gson();

    String str = "{\"status\":0,\"message\":\"\",\"data\":{\"header\":[\"vmScoreAvg\",\"vmScoreDiff\",\"cdnScoreAvg\",\"cdnScoreDiff\",\"scoreAvg\",\"scoreDiff\"],\"rows\":[{\"Ab72ed2d2a8\":[4.623612773828638,2.6256731292866022,0.0,0.0,4.623612773828638,2.6256731292866022]},{\"International-hacker\":[4.609395323075055,2.6252815469565247,0.0,0.0,4.609395323075055,2.6252815469565247]}]},\"total\":29334}";

    @Test
    public void test() {
//        UserActiveResultEntity ua = gson.fromJson(str, UserActiveResultEntity.class);
//        String str = LocalDate.now().plusDays(2).getDayOfWeek().toString();
//        if (str.equals("SUNDAY")) {
//            System.out.println(LocalDate.now().plusDays(2).getDayOfWeek());
//        }
////        System.out.println(ua.getData().getRows());
//        for (Map<String, Double[]> map : ua.getData().getRows()) {
//            for (Map.Entry<String, Double[]> entry : map.entrySet()) {
//                String key = entry.getKey();
//                Double[] value = entry.getValue();
//                System.out.println(key);
//                for (int i =0; i< value.length; i++) {
//                    System.out.println(value[i]);
//                }
//                System.out.println();
//            }
//        }
    }

    @Test
    public void test1() throws Exception {
//        userActiveTask.getResult();
        System.out.println(DateUtils.getWeek("2018-08-19"));
        if (DateUtils.getWeek("2018-08-19").equals("星期日")) {
            System.out.println("happy");
        }
    }
}
