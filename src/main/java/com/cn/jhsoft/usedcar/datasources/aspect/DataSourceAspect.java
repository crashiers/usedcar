package com.cn.jhsoft.usedcar.datasources.aspect;

import com.cn.jhsoft.usedcar.datasources.annotation.DataSource;
import com.cn.jhsoft.usedcar.datasources.DataSourceNames;
import com.cn.jhsoft.usedcar.datasources.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017/9/16 22:20
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    // @within 是类上的注解
    // @annotation 是方法上的注解
    @Pointcut("@within(com.cn.jhsoft.usedcar.datasources.annotation.DataSource) || @annotation(com.cn.jhsoft.usedcar.datasources.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        // 方法上的注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource dsWithMethod = method.getAnnotation(DataSource.class);

        // 类上的注解
        DataSource dsWithClass = method.getDeclaringClass().getAnnotation(DataSource.class);

        if(dsWithMethod == null && dsWithClass == null){
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            logger.debug("set datasource is " + DataSourceNames.FIRST);
        }else if (dsWithMethod != null){
            DynamicDataSource.setDataSource(dsWithMethod.name());
            logger.debug("set datasource is " + dsWithMethod.name());
        }else if (dsWithClass != null){
            DynamicDataSource.setDataSource(dsWithClass.name());
            logger.debug("set datasource is " + dsWithClass.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
