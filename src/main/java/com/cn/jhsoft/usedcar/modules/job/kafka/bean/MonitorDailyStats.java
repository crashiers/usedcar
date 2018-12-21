package com.cn.jhsoft.usedcar.modules.job.kafka.bean;

/**
 * Created by chenyi9 on 2018/5/18.
 */
public class MonitorDailyStats {
    private Long timestamp;
    private String metric;
    private String value;
    private String resourceId;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "MonitorDailyStats{" +
                "timestamp=" + timestamp +
                ", metric='" + metric + '\'' +
                ", value='" + value + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
