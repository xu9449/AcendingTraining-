package com.sean.debug12.init;

import com.sean.debug12.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication(scanBasePackages = {"com.sean.debug12"})
//@ServletComponentScan(basePackages = {"com.sean.debug.filter"})
public class Appbootstrap extends SpringBootServletInitializer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        //AppInitializer app = new AppInitializer();
        SpringApplication.run(Appbootstrap.class, args);
    }


}
