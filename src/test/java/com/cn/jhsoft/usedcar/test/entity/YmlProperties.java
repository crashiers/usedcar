package com.cn.jhsoft.usedcar.test.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.logpath")
public class YmlProperties {

    /**
     * 像这样使用...
     * @Autowired
     * private YmlProperties ymlProperties;
     *
     * System.out.println(ymlProperties.getTmp_log_path());
     * System.out.println(ymlProperties.getFlume_log_path());
     */

    private String tmp_log_path;
    private String flume_log_path;

    public String getTmp_log_path() {
        return tmp_log_path;
    }

    public void setTmp_log_path(String tmp_log_path) {
        this.tmp_log_path = tmp_log_path;
    }

    public String getFlume_log_path() {
        return flume_log_path;
    }

    public void setFlume_log_path(String flume_log_path) {
        this.flume_log_path = flume_log_path;
    }
}
