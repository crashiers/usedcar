package com.cn.jhsoft.usedcar.modules.api.controller;

import com.alibaba.fastjson.JSON;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.Md5Util;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.RedisKeys;
import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.utils.RedisUtils;
import com.cn.jhsoft.usedcar.modules.sign.service.SignSystemService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenyi9 on 2018/11/14.
 */
@RestController
@RequestMapping(value="/api")
public class ApiSignSystemController {

    @Autowired
    private SignSystemService signSystemService;

    @Autowired
    private RedisUtils redisUtils;

    // redis 过期时间,20分钟
    private final Long REDIS_EXPIRE_TIME = 1200L;
    // api接口 超时时间,10分钟
    private final Long API_EXPIRE_TIME = 600L;
    // 盐
    private final String SALT = "ZXw@qGk!NO8@W6F&tW#*Tz*dwrh!FNRV";

    /**
     * 大客标签
     */
    @AuthIgnore
    @GetMapping("sign")
    public R signList(@RequestParam Map<String, Object> param){

        if (param.get("token") == null || "".equals(param.get("token").toString())){
            return R.error(-1, "参数错误");
        }
        if (param.get("timestamp") == null || "".equals(param.get("timestamp").toString())){
            return R.error(-1, "参数错误");
        }
        if (param.get("appId") == null || "".equals(param.get("appId").toString())){
            return R.error(-1, "参数错误");
        }
        String token = param.get("token").toString();
        String timestamp = param.get("timestamp").toString();
        String appId = param.get("appId").toString();
        // 检验 timestamp是否正确，是否在 5 秒之内
        if (DateUtils.getTimeStamp() - Long.parseLong(timestamp) > API_EXPIRE_TIME){
            return R.error(-2, "超时");
        }
        // 检测 token是否正确
        if (!Md5Util.NewMd5(appId+SALT+timestamp).equals(token.toLowerCase())){
            return R.error(-3, "不合法");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("limit", param.get("limit") == null || "".equals(param.get("limit").toString()) ? 200 : param.get("limit").toString());
        params.put("page", param.get("page") == null || "".equals(param.get("page").toString()) ? 1 : param.get("page").toString());
        int page = Integer.parseInt(params.get("page").toString());
        int limit = Integer.parseInt(params.get("limit").toString());

        String pin = "";
        if (param.get("pin") != null && !"".equals(param.get("pin").toString())){
            params.put("pin", pin = param.get("pin").toString());
        }
        String utmSource = "";
        if (param.get("utm_source") != null && !"".equals(param.get("utm_source").toString())){
            params.put("utm_source", utmSource = param.get("utm_source").toString());
        }
        String isVip = "";
        if (param.get("is_vip") != null && !"".equals(param.get("is_vip").toString())){
            params.put("is_vip", isVip = param.get("is_vip").toString());
        }
        String isVvip = "";
        if (param.get("is_vvip") != null && !"".equals(param.get("is_vvip").toString())){
            params.put("is_vvip", isVvip = param.get("is_vvip").toString());
        }
        Query query = new Query(params);

        boolean hasRedisSignSystemAllAmountKey = false;
        boolean redisConnectionSuccess = true;
        String amountRedisKeys = RedisKeys.SING_SYSTEM_ALL_AMOUNT + "_" + pin + "_" + utmSource + "_" + isVip + "_" + isVvip;
        try{
            hasRedisSignSystemAllAmountKey = redisUtils.hasKey(amountRedisKeys);
        }catch (Exception ex){
            redisConnectionSuccess = false;
        }

        // 记录数
        long amount = 0L;
        // 存在于redis中，或者连接不成功
        if (!redisConnectionSuccess || !hasRedisSignSystemAllAmountKey) {
            // 从 db 中取数据
            amount = signSystemService.queryTotal(query);

            // 存入redis
            if (redisConnectionSuccess) {
                redisUtils.set(amountRedisKeys, amount, REDIS_EXPIRE_TIME);
            }
        }else{
            // 从redis中取数据
            amount = Long.parseLong(redisUtils.get(amountRedisKeys));
        }

        // 列表
        String ref = "redis";
        List<Object> lists = new LinkedList<>();
        String redisKey = RedisKeys.SING_SYSTEM_ALL + "_" + page + "_" + limit + "_" + pin + "_" + utmSource + "_" + isVip + "_" + isVvip;
        if (amount > 0) {
            if (!redisConnectionSuccess || !redisUtils.hasKey(redisKey)) {
                // redis中没有数据
                ref = "db";
                lists = signSystemService.queryObjectList(query);

                // 存入redis
                if (redisConnectionSuccess) {
                    redisUtils.set(RedisKeys.SING_SYSTEM_ALL_AMOUNT, amount, REDIS_EXPIRE_TIME);
                    for (Object entity : lists) {
                        redisUtils.lSet(redisKey, JSON.toJSON(entity).toString(), REDIS_EXPIRE_TIME);
                    }
                }
            } else {
                // 从redis中取数据
                List<Object> redisLists = redisUtils.lGet(redisKey, 0, limit);
                for (Object s : redisLists) {
                    lists.add(JSON.parseObject(s.toString(), Object.class));
                }
            }
        }

        // 字段过滤
        String fields = "customer_id,company_name,industry,city,pin,utm_source,is_customer,is_workloads,business_deploy,is_techservice,is_stability,is_security,is_happy_customers,is_vvip,contact_level,seep_level,is_iaas,is_lb,is_cdn,is_idc,is_db,is_redis,is_storage,is_saas,is_data_saas,is_other_saas,is_group_saas";
        if (param.get("fields") != null && !"".equals(param.get("fields").toString())){
            fields = param.get("fields").toString();
        }
        String[] fieldArray = fields.split(",");

        Map<String, Object> m;
        for (Object o : lists){
            m = (Map<String, Object>)o;
            Iterator<String> it = m.keySet().iterator();
            while (it.hasNext()){
                String k = it.next();
                if (!ArrayUtils.contains(fieldArray, k)){
                    it.remove();
                }
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("ref", ref);
        result.put("data", lists);
        result.put("amount", amount);
        result.put("code", 200);
        result.put("msg", "ok");

        return R.ok(result);

    }


    @AuthIgnore
    @GetMapping("signurl")
    public String signUrl(@RequestParam Map<String, Object> param){
        long timestamp = DateUtils.getTimeStamp();
        String appId = param.get("appId") == null || "".equals(param.get("appId").toString()) ? "abc" : param.get("appId").toString();
        String salt = "ZXw@qGk!NO8@W6F&tW#*Tz*dwrh!FNRV";
        String token = Md5Util.NewMd5(appId + salt + timestamp);
        String url = "xx";
        url += "?appId="+appId;
        url += "&amp;timestamp="+timestamp;
        url += "&token="+token;

        return url;
    }

}
