package com.cn.jhsoft.usedcar.test;

import com.cn.jhsoft.usedcar.common.utils.RedisUtils;
import com.cn.jhsoft.usedcar.MyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenyi9 on 2018/11/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void listTest(){
//        redisUtils.lSet("abc", "1");
//        redisUtils.lSet("abc", "2");
//        redisUtils.lSet("abc", "3");
        System.out.println(redisUtils.lGetListSize("abc"));
        System.out.println(redisUtils.lGet("abc", 1, 2));
        redisUtils.expire("abc", 10);
    }

}
