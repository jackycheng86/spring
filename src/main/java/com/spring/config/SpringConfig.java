package com.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jackycheng
 * @date 2017-12-29-下午3:56
 */

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
