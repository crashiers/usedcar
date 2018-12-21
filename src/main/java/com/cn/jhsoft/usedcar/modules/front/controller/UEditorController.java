package com.cn.jhsoft.usedcar.modules.front.controller;

import com.jhsoft.ueditor.ActionEnter;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jhsoft on 2017/4/9.
 */
@Controller
@RequestMapping("/editor")
public class UEditorController {

    @Value("${spring.fileupload.upload_path}")
    private String uploadPath;


    @RequestMapping("/show")
    private String showPage(){
        return "modules/front/editor";
    }

    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {

            // 如果传了宽度和高度，那就生成缩略图，默认editor里是不传的，所以不会生成。
            String[] widths = new String[]{}, heights = new String[]{};
            if (request.getParameter("width") != null)
                widths = request.getParameter("width").toString().split(",");
            if (request.getParameter("height") != null)
                heights = request.getParameter("height").toString().split(",");
            String exec = new ActionEnter(request, rootPath, uploadPath, widths, heights).exec();

            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
