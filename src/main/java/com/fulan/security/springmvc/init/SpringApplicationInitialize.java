package com.fulan.security.springmvc.init;

import com.fulan.security.springmvc.config.ApplicationConfig;
import com.fulan.security.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringApplicationInitialize extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                ApplicationConfig.class
        };//指定rootContext的配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };//指定ServletContext的配置类
    }

    //url-mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
