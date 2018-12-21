package com.cn.jhsoft.usedcar.modules.job.task;

import com.cn.jhsoft.usedcar.common.utils.GzipUtils;
import com.cn.jhsoft.usedcar.common.utils.HttpRequest;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenyi9 on 2017/9/30.
 */
@Component("wifiDeviceTask")
public class WifiDeviceTask {

    @Value("${spring.logpath.tmp_log_path}")
    private String tmpLogPath;

    public R postWifiApi(String params) throws Exception {

        // 行号
        int lineNum = 0;
        File file = new File(tmpLogPath+"flume.access.log.num");
        if (file.exists()) {
            FileReader fr = new FileReader(file);
            char[] chars = new char[1024];
            int len = fr.read(chars);
            lineNum = Integer.valueOf(new String(chars, 0, len));
        }

        // 读取一行，并记录新行号
        FileReader fr = new FileReader(tmpLogPath+"20170920_flume.access.log.007db722");
        File file_log = new File(tmpLogPath+"20170920_flume.access.log.007db816");
        if (file_log.exists()){
            fr = new FileReader(file_log);
        }
        LineNumberReader br = new LineNumberReader(fr);
        int i = 0;
        int onceNum = 1;
        if (params != null && !"".equals(params)){
            onceNum = Integer.valueOf(params);
            onceNum = onceNum + new Random().nextInt(onceNum);
        }
        String lineContent = null;
        List<String> lineContents = new ArrayList<>();
        while ((lineContent = br.readLine()) != null) {
            if (i < lineNum){
                lineContent = null;
            }else if (i>=lineNum && i< lineNum + onceNum){
                lineContents.add(lineContent);
            }
            else{
                break;
            }
            i++;
        }
        if (lineContent == null){
            //System.out.println("已读完");
            //return R.error("已读完");
            // 写入0行号
            FileWriter fw = new FileWriter(file);
            fw.write(""+0);
            fw.close();
            throw new Exception("已读完");
        }



        // 把那一行内容拼装成 json
        // 整串json
        JsonArray jsonArray = new JsonArray();
        JsonObject parentJo = new JsonObject();
        for (String _lineContent: lineContents) {
            JsonObject jo = new JsonParser().parse(_lineContent).getAsJsonObject();
            parentJo.addProperty("id", jo.get("id").getAsString());
            parentJo.addProperty("mmac", jo.get("mmac").getAsString());
            parentJo.addProperty("lat", jo.get("lat").getAsString());
            parentJo.addProperty("lon", jo.get("lon").getAsString());
            jsonArray.add(jo);
        }
        parentJo.add("data", jsonArray);

        // 请求网关接口 post数据
        String str = "data="+parentJo.toString();

        byte[] bytes = GzipUtils.compress(str.getBytes());

        //发送 POST 请求
        String sr1= HttpRequest.sendPost("http://localhost:8091/f/zapi1", bytes);
        if ("1".equals(sr1)) {
            // 写入新行号
            FileWriter fw = new FileWriter(file);
            fw.write(""+(lineNum+onceNum));
            fw.close();
        }

        return R.ok();
    }

}
