package com.cn.jhsoft.usedcar.modules.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GongHaiTao {

    // value这种的在 别的方法上加注解时，可以不用写 value=2，直接 @GonghaiTao(1)
    public int value() default 1;

    // 其它的都需要加这个名字 @GonghaiTao(id=111)
    public int id() default 100;

}
