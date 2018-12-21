package com.cn.jhsoft.usedcar.test;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.google.gson.Gson;
import com.cn.jhsoft.usedcar.common.utils.GzipUtils;
import com.cn.jhsoft.usedcar.common.utils.HttpRequest;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created by chenyi9 on 2017/9/6.
 */
public class MyTest {

    public static final Gson gson = new Gson();
    private int id;
    private String uname;

    @Test
    public void getTime() {
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(1504841403154L));
        System.out.println(date);
        System.out.println((int) Math.ceil((float) 4 / 10L));

        String a = "0:1:";
        System.out.println(a.split(":").length);

        String url = "http://www.abc";
        System.out.println(url.matches("^http.*"));

        String url1 = "HUAWEI TECHNOLOGIES CO. LTD";
        System.out.println(url1.matches(".*HUAWEI.*"));

        Date e = new Date();
        System.out.println(DateUtils.getHour(DateUtils.getDate(1507008840052L)));
        System.out.println(DateUtils.getYesterdayDate());
    }


    /**
     * 测试压缩和解压
     *
     * @throws Exception
     */
    @Test
    public void te() throws Exception {
        String str = "data={\"id\":\"007db816\",\"data\":[{\"mac\":\"20:f4:1b:7d:b8:16\",\"rssi\":\"-24\",\"router\":\"datasky\",\"range\":\"1.0\"},{\"mac\":\"ac:74:09:69:d7:80\",\"rssi\":\"-68\",\"router\":\"jhsoft\",\"range\":\"12.9\"},{\"mac\":\"ac:74:09:69:d7:81\",\"rssi\":\"-68\",\"range\":\"12.9\"},{\"mac\":\"ac:74:09:69:d7:83\",\"rssi\":\"-66\",\"router\":\"jhsoft_guest\",\"range\":\"10.8\"},{\"mac\":\"48:45:20:cf:1b:29\",\"rssi\":\"-64\",\"rssi1\":\"-73\",\"ts\":\"jhsoft\",\"tmc\":\"ac:74:09:69:d7:80\",\"tc\":\"Y\",\"range\":\"9.1\"},{\"mac\":\"ac:74:09:69:de:10\",\"rssi\":\"-79\",\"range\":\"33.0\"},{\"mac\":\"48:45:20:70:e2:0c\",\"rssi\":\"-76\",\"rssi1\":\"-75\",\"range\":\"25.5\"},{\"mac\":\"48:45:20:cf:38:93\",\"rssi\":\"-69\",\"ds\":\"Y\",\"range\":\"14.0\"},{\"mac\":\"4a:45:20:cf:38:93\",\"rssi\":\"-72\",\"router\":\"zbuy\",\"range\":\"18.1\"},{\"mac\":\"20:68:9d:06:68:63\",\"rssi\":\"-70\",\"range\":\"15.3\"},{\"mac\":\"1a:5e:0f:bf:df:74\",\"rssi\":\"-87\",\"range\":\"65.2\"},{\"mac\":\"ac:74:09:69:d7:82\",\"rssi\":\"-66\",\"router\":\"jhsoft_mobile\",\"range\":\"10.8\"},{\"mac\":\"ac:74:09:69:de:11\",\"rssi\":\"-74\",\"router\":\"jhsoft_access\",\"range\":\"21.5\"},{\"mac\":\"ac:74:09:69:de:12\",\"rssi\":\"-74\",\"router\":\"J\n" +
                "D_mobile\",\"range\":\"21.5\"},{\"mac\":\"14:cf:92:0e:15:fe\",\"rssi\":\"-78\",\"range\":\"30.3\"},{\"mac\":\"ac:74:09:69:cb:20\",\"rssi\":\"-85\",\"range\":\"55.0\"},{\"mac\":\"ac:74:09:6a:06:f0\",\"rssi\":\"-74\",\"rssi1\":\"-75\",\"rssi2\":\"-74\",\"rssi3\":\"-75\",\"range\":\"21.5\"},{\"mac\":\"ac:74:09:6a:06:f1\",\"rssi\":\"-75\",\"range\":\"23.4\"},{\"mac\":\"ac:74:09:6a:06:f2\",\"rssi\":\"-74\",\"range\":\"21.5\"},{\"mac\":\"ac:74:09:6a:06:f3\",\"rssi\":\"-75\",\"range\":\"23.4\"},{\"mac\":\"ac:74:09:68:c9:60\",\"rssi\":\"-46\",\"router\":\"jhsoft\",\"range\":\"1.9\"},{\"mac\":\"ac:74:09:68:c9:61\",\"rssi\":\"-47\",\"router\":\"jhsoft_access\",\"range\":\"2.1\"},{\"mac\":\"ac:74:09:68:c9:62\",\"rssi\":\"-47\",\"router\":\"jhsoft_mobile\",\"range\":\"2.1\"},{\"mac\":\"ac:74:09:68:c9:63\",\"rssi\":\"-46\",\"router\":\"jhsoft_guest\",\"range\":\"1.9\"},{\"mac\":\"ac:74:09:69:66:b0\",\"rssi\":\"-80\",\"range\":\"35.9\"},{\"mac\":\"4c:34:88:c4:e8:cf\",\"rssi\":\"-77\",\"range\":\"27.8\"},{\"mac\":\"fa:59:71:87:3d:d1\",\"rssi\":\"-76\",\"range\":\"25.5\"},{\"mac\":\"10:08:b1:d4:ae:3b\",\"rssi\":\"-74\",\"range\":\"21.5\"},{\"mac\":\"80:19:34:39:71:5f\",\"rssi\":\"-83\",\"ds\":\"Y\",\"range\":\"46.4\"},{\"mac\":\"dc:\n" +
                "09:4c:f0:ef:39\",\"rssi\":\"-60\",\"ds\":\"Y\",\"range\":\"6.5\"}],\"mmac\":\"20:f4:1b:7d:b8:16\",\"rate\":\"1\",\"time\":\"Fri Aug 18 13:51:48 2017\",\"lat\":\"\",\"lon\":\"\"}";
        byte[] bytes = str.getBytes();
        byte[] bytes2 = GzipUtils.compress(bytes);
        System.out.println(IOUtils.toString(bytes2, "utf-8"));
        byte[] decompress = GzipUtils.decompress(bytes2);
        System.out.println(new String(decompress));


    }

    /**
     * 测试压缩提交数据 post到 url，http请求
     *
     * @throws IOException
     */
    @Test
    public void tee() throws IOException {
        String str = "data={\"id\":\"007db816\",\"data\":[{\"mac\":\"20:f4:1b:7d:b8:16\",\"rssi\":\"-24\",\"router\":\"datasky\",\"range\":\"1.0\"},{\"mac\":\"ac:74:09:69:d7:80\",\"rssi\":\"-68\",\"router\":\"jhsoft\",\"range\":\"12.9\"},{\"mac\":\"ac:74:09:69:d7:81\",\"rssi\":\"-68\",\"range\":\"12.9\"},{\"mac\":\"ac:74:09:69:d7:83\",\"rssi\":\"-66\",\"router\":\"jhsoft_guest\",\"range\":\"10.8\"},{\"mac\":\"48:45:20:cf:1b:29\",\"rssi\":\"-64\",\"rssi1\":\"-73\",\"ts\":\"jhsoft\",\"tmc\":\"ac:74:09:69:d7:80\",\"tc\":\"Y\",\"range\":\"9.1\"},{\"mac\":\"ac:74:09:69:de:10\",\"rssi\":\"-79\",\"range\":\"33.0\"},{\"mac\":\"48:45:20:70:e2:0c\",\"rssi\":\"-76\",\"rssi1\":\"-75\",\"range\":\"25.5\"},{\"mac\":\"48:45:20:cf:38:93\",\"rssi\":\"-69\",\"ds\":\"Y\",\"range\":\"14.0\"},{\"mac\":\"4a:45:20:cf:38:93\",\"rssi\":\"-72\",\"router\":\"zbuy\",\"range\":\"18.1\"},{\"mac\":\"20:68:9d:06:68:63\",\"rssi\":\"-70\",\"range\":\"15.3\"},{\"mac\":\"1a:5e:0f:bf:df:74\",\"rssi\":\"-87\",\"range\":\"65.2\"},{\"mac\":\"ac:74:09:69:d7:82\",\"rssi\":\"-66\",\"router\":\"jhsoft_mobile\",\"range\":\"10.8\"},{\"mac\":\"ac:74:09:69:de:11\",\"rssi\":\"-74\",\"router\":\"jhsoft_access\",\"range\":\"21.5\"},{\"mac\":\"ac:74:09:69:de:12\",\"rssi\":\"-74\",\"router\":\"J\n" +
                "D_mobile\",\"range\":\"21.5\"},{\"mac\":\"14:cf:92:0e:15:fe\",\"rssi\":\"-78\",\"range\":\"30.3\"},{\"mac\":\"ac:74:09:69:cb:20\",\"rssi\":\"-85\",\"range\":\"55.0\"},{\"mac\":\"ac:74:09:6a:06:f0\",\"rssi\":\"-74\",\"rssi1\":\"-75\",\"rssi2\":\"-74\",\"rssi3\":\"-75\",\"range\":\"21.5\"},{\"mac\":\"ac:74:09:6a:06:f1\",\"rssi\":\"-75\",\"range\":\"23.4\"},{\"mac\":\"ac:74:09:6a:06:f2\",\"rssi\":\"-74\",\"range\":\"21.5\"},{\"mac\":\"ac:74:09:6a:06:f3\",\"rssi\":\"-75\",\"range\":\"23.4\"},{\"mac\":\"ac:74:09:68:c9:60\",\"rssi\":\"-46\",\"router\":\"jhsoft\",\"range\":\"1.9\"},{\"mac\":\"ac:74:09:68:c9:61\",\"rssi\":\"-47\",\"router\":\"jhsoft_access\",\"range\":\"2.1\"},{\"mac\":\"ac:74:09:68:c9:62\",\"rssi\":\"-47\",\"router\":\"jhsoft_mobile\",\"range\":\"2.1\"},{\"mac\":\"ac:74:09:68:c9:63\",\"rssi\":\"-46\",\"router\":\"jhsoft_guest\",\"range\":\"1.9\"},{\"mac\":\"ac:74:09:69:66:b0\",\"rssi\":\"-80\",\"range\":\"35.9\"},{\"mac\":\"4c:34:88:c4:e8:cf\",\"rssi\":\"-77\",\"range\":\"27.8\"},{\"mac\":\"fa:59:71:87:3d:d1\",\"rssi\":\"-76\",\"range\":\"25.5\"},{\"mac\":\"10:08:b1:d4:ae:3b\",\"rssi\":\"-74\",\"range\":\"21.5\"},{\"mac\":\"80:19:34:39:71:5f\",\"rssi\":\"-83\",\"ds\":\"Y\",\"range\":\"46.4\"},{\"mac\":\"dc:\n" +
                "09:4c:f0:ef:39\",\"rssi\":\"-60\",\"ds\":\"Y\",\"range\":\"6.5\"}],\"mmac\":\"20:f4:1b:7d:b8:16\",\"rate\":\"1\",\"time\":\"Fri Aug 18 13:51:48 2017\",\"lat\":\"\",\"lon\":\"\"}";

        byte[] bytes = GzipUtils.compress(str.getBytes());

        //发送 POST 请求
        String sr1 = HttpRequest.sendPost("http://localhost:8091/f/zapi", bytes);
        System.out.println(sr1);
    }

    @Test
    public void testHbaseVehicle() throws IOException {

        /*
        * [{"rowKey":"1004","BRAND":"001","CITY_ID":"18","LOGIN_TIME":"20170921","LOGOUT":"20170921","STATUS":"1","TERMINAL_CODE":"99"}]
        * */
        String jsonStr = "[{\"rowKey\":\"1004\",\"BRAND\":\"001\",\"CITY_ID\":\"18\",\"LOGIN_TIME\":\"20170921\",\"LOGOUT\":\"20170921\",\"STATUS\":\"1\",\"TERMINAL_CODE\":\"99\"}]";
        byte[] bytes = jsonStr.getBytes();

        //发送 POST 请求
        String sr1 = HttpRequest.sendPost("http://localhost:8091/h/vehicle", bytes);
        System.out.println(sr1);
    }

    @Test
    public void testHttpClient() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();


        String smsUrl = "http://www.baidu.com";
        HttpGet httppost = new HttpGet(smsUrl);
        String strResult = "";

        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(EntityUtils.toString(response.getEntity()));

        } else {
            String err = response.getStatusLine().getStatusCode() + "";
            strResult += "发送失败:" + err;
            System.out.println(strResult);
        }
    }



}
