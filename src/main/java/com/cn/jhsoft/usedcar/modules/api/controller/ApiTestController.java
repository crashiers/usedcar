package com.cn.jhsoft.usedcar.modules.api.controller;


import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import com.cn.jhsoft.usedcar.modules.api.annotation.LoginUser;
import com.cn.jhsoft.usedcar.modules.api.entity.TokenEntity;
import com.cn.jhsoft.usedcar.modules.api.entity.UserEntity;
import com.cn.jhsoft.usedcar.common.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * API测试接口
 *
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
// 解决编码问题，可以是上面这种方法，也可以在  spring boot配置文件中增加spring.http.encoding.force=true这个配置项即可。
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @GetMapping("userInfo")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    /**
     * 忽略Token验证测试
     */
    @AuthIgnore
    @GetMapping("notToken")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

    /**
     * 接收JSON数据
     */
    @PostMapping("jsonData")
    public R jsonData(@LoginUser UserEntity user, @RequestBody TokenEntity token){
        return R.ok().put("user", user).put("token", token);
    }
}
