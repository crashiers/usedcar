package com.cn.jhsoft.usedcar.test;

import com.cn.jhsoft.usedcar.MyApplication;
import com.cn.jhsoft.usedcar.common.utils.RedisUtils;
import com.cn.jhsoft.usedcar.test.entity.YmlProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class MyApplicationTests {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private YmlProperties ymlProperties;

    @Test
    public void contextLoads() throws IOException {
        //redisUtils.incrBy(RedisKeys.getLogHourKey(12), 5);

        System.out.println(ymlProperties.getFlume_log_path());
        System.out.println(ymlProperties.getTmp_log_path());


    }


    @Test
    public void testRedisList(){
        redisUtils.setList("page_chenyi363", "aaa");
        List<Object> page_chenyi363 = redisUtils.getList("page_chenyi363", 0, -1);
        System.out.println(page_chenyi363);

    }

}