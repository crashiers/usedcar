package com.cn.jhsoft.usedcar.modules.front.controller;

import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chenyi9 on 2017/9/6.
 */
@Controller
public class IndexController {

    /**
     * 后台
     */
    @AuthIgnore
    @GetMapping("/man")
    public void man(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/admin.html");
    }

    /**
     * 客户管理平台
     */
    @AuthIgnore
    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/admin.html");
    }

}
