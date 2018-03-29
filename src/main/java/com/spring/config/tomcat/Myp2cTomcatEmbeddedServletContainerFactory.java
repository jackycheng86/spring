package com.spring.config.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import java.io.File;

/**
 * com.spring.config.tomcat
 * @author  jackycheng
 * 2017/10/18
 *
 * 扩展内置tomcat，添加自定义域名以及多域名支持
 *
 **/
public class Myp2cTomcatEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {

    @Override
    public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {
        Tomcat tomcat = new Tomcat();
        File baseDir = (createTempDir("tomcat"));
        tomcat.setBaseDir(baseDir.getAbsolutePath());
        tomcat.setHostname("sso.myp2c.me");
        StandardHost host=(StandardHost)tomcat.getHost();
        if(host!=null){
            host.addAlias("sso1.myp2c.me");
            host.addAlias("sso2.myp2c.me");
            tomcat.setHost(host);
        }
        tomcat.getHost().setAutoDeploy(false);
        tomcat.getEngine().setBackgroundProcessorDelay(-1);
        for (Connector additionalConnector : super.getAdditionalTomcatConnectors()) {
            tomcat.getService().addConnector(additionalConnector);
        }
        prepareContext(tomcat.getHost(), initializers);
        return getTomcatEmbeddedServletContainer(tomcat);
    }


}
