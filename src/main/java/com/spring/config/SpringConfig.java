package com.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author jackycheng
 * @date 2017-12-29-下午3:56
 *
 * 文件上传配置
 */
@Configuration
@ConfigurationProperties("storage")
public class SpringConfig {
    private String location = "/tmp/files";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
