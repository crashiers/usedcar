package com.cn.jhsoft.usedcar.test;

import com.cn.jhsoft.usedcar.MyApplication;
import com.cn.jhsoft.usedcar.modules.job.task.QuestionnaireTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by liuyongdong on 2018/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class queTest {
    @Autowired
    QuestionnaireTask questionnaireTask;

    @Test
    public void Test() {
        questionnaireTask.run();
    }

}
