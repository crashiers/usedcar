package com.cn.jhsoft.usedcar.test;

import com.cn.jhsoft.usedcar.modules.pm.service.AHPComputeWeight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by liuyongdong on 2018/5/3.
 */
public class AHPTest {
    AHPComputeWeight ahpComputeWeight;

    @Before
    public void before() throws Exception {
        Double[][] a= {{1D, 1.0/3, 3D, 1D/7},{3D, 1D, 5D, 1D/5},{1D/3, 1D/5, 1D, 1D/9},{7D, 5D, 9D, 1D}};
        System.out.println(a);
        ahpComputeWeight = new AHPComputeWeight(a, 10);
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testEvaluate() throws Exception {
        Map<String, Object> result = ahpComputeWeight.calculate();
        System.out.println(result.get("lamta"));
        System.out.println(result.get("CI"));
        System.out.println(result.get("CR"));
        double[] weight = (double[]) result.get("weight");
        System.out.println("权重向量:");
        for (double i : weight) {
            System.out.print(i + " ");
            System.out.println();
        }
    }
}
