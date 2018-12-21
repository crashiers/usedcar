package com.cn.jhsoft.usedcar.modules.job.kafka.consumer.impl;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.modules.job.kafka.consumer.AbstractConsumer;
import com.cn.jhsoft.usedcar.modules.job.kafka.bean.MonitorDailyStats;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chenyi9 on 2018/5/18.
 */
@Component
public class MonitorDailyStatsConsumer extends AbstractConsumer<MonitorDailyStats> {


    @Override
    //@KafkaListener(topics = {"william", "monitor-daily-stats"})
    //@KafkaListener(topics = "customer360_user_lifecycle")
    public void listen(ConsumerRecord<?, ?> record) {
        //System.out.printf("offset = %d,topic= %s,partition=%s,key =%s,value=%s\n", record.offset(), record.topic(), record.partition(), record.key(), record.value());
        //logger.info(record.value()+"");
        //String v = record.value().toString();

//        Pattern pattern = Pattern.compile("\\\"serviceCode\\\":\\\"(ip|disk)\\\"");
//        Matcher matcher = pattern.matcher(v);
//        if (matcher.find()) {
//            System.out.println(v);
//        }
        System.out.println(record.value());


        //MonitorDailyStats info = JSON.parseObject(record.value().toString(), MonitorDailyStats.class);
        //updateOrInsert(info);
    }

    @Override
    public void updateOrInsert(MonitorDailyStats info) {

    }
}
