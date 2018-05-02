package com.spring.config.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import java.io.File;

/**
 * @author chengjian
 * @date 2018/3/27
 **/

public class Myp2cTomcatCustomizationBean extends TomcatServletWebServerFactory{
    @Override
    public WebServer getWebServer(ServletContextInitializer... initializers) {
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
        return getTomcatWebServer(tomcat);
    }
}
