package com.spring;

import com.spring.config.tomcat.Myp2cTomcatEmbeddedServletContainerFactory;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * com.hw.myp2c
 * jackycheng
 * 2017/10/19
 **/
@Configuration
public class TomcatInitializer {


    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        Myp2cTomcatEmbeddedServletContainerFactory tomcat = new Myp2cTomcatEmbeddedServletContainerFactory();
        tomcat.setUriEncoding(Charset.forName("UTF-8"));
        tomcat.addAdditionalTomcatConnectors(createNioConnector());
        return tomcat;
    }

    public Connector createNioConnector(){
        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8088);//自定义的端口
        return connector;
    }
}
