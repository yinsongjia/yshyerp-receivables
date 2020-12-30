package com.yshyerp.receivables;

import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MapperScan("com.yshyerp.receivables.mapper")
@SpringBootApplication
public class YshyerpReceivablesApplication {

    public static void main(String[] args) {
        SpringApplication.run(YshyerpReceivablesApplication.class, args);
    }



}
