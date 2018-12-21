package com.cn.jhsoft.usedcar.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyi9 on 2018/9/19.
 */
public class JsonTest {

    @Test
    public void testJson(){
        String postStr = "{\"c\":8.0,\"m\":8.0}";
        String postStr1 = "[{\"key\":\"c\",\"unit\":\"c\",\"value\":1.0},{\"key\":\"m\",\"unit\":\"m\",\"value\":1.0},{\"key\":\"d\",\"unit\":\"d\",\"value\":40.0},{\"key\":\"dc\",\"unit\":\"cn-south-1\",\"value\":0.0}]";
        //JsonObject allData = new JsonParser().parse(postStr).getAsJsonObject();
        JsonElement parse = new JsonParser().parse(postStr);
        JsonElement parse1 = new JsonParser().parse(postStr1);
        System.out.println(parse1.isJsonArray());
        System.out.println(parse.isJsonObject());

        // map
        JsonObject jsonObject = parse.getAsJsonObject();
        Map<String, Double> map = new HashMap<String, Double>();
        for (Map.Entry<String, JsonElement> m : jsonObject.entrySet()){
            //map.put(m.getKey(), Double.valueOf(String.valueOf(m.getValue())));
        }

        // list
        JsonArray jsonArray = parse1.getAsJsonArray();
        String k  = "";
        Double v = 0d;
        for (JsonElement je : jsonArray){
            for (Map.Entry<String, JsonElement> m : je.getAsJsonObject().entrySet()){
                if (m.getKey().equals("key")) {
                    k = m.getValue().getAsString();
                }else if(m.getKey().equals("value")){
                    v = Double.valueOf(String.valueOf(m.getValue().getAsString()));
                }
            }
            map.put(k, v);
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }


        //System.out.println(allData);
    }

}
