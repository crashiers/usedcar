package com.cn.jhsoft.usedcar.common.aspect;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.HttpContextUtils;
import com.cn.jhsoft.usedcar.common.utils.RedisKeys;
import com.cn.jhsoft.usedcar.common.annotation.ClientLog;
import com.cn.jhsoft.usedcar.common.utils.RedisUtils;
import com.cn.jhsoft.usedcar.modules.sys.entity.SysUserEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenyi9 on 2018/1/10.
 */
@Aspect
@Component
public class ClientLogAspect {

    @Autowired
    private RedisUtils redisUtils;

    @Pointcut("@annotation(com.cn.jhsoft.usedcar.common.annotation.ClientLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        // 记日志
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        SysUserEntity user = (SysUserEntity) request.getAttribute("user");
        StringBuilder sb = new StringBuilder();
        sb.append(user.getUsername()+" ");
        sb.append(DateUtils.getTodayDateYMD()+" ");
        sb.append(HttpContextUtils.getPageUrl());
        try {
            redisUtils.setList(RedisKeys.PAGE_KEY + user.getUsername(), sb.toString());


            // 记录 客户维度的日志
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            ClientLog clientLog = method.getAnnotation(ClientLog.class);
            if (clientLog.type().equals("customerDetail")){

                // 匹配url中包含   /数字  或者  id=数字   这种，取id号
                Pattern pattern = Pattern.compile("((\\/)|id=)(\\d+)");
                Matcher matcher = pattern.matcher(HttpContextUtils.getPageUrl());
                if (matcher.find()) {
                    redisUtils.setList(RedisKeys.USER_KEY + matcher.group(3), sb.toString());
                }

            }

        }catch (Exception ex){

        }

        return result;
    }

}
