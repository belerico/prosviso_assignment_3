package com.assignment3.struts2.listener;

import com.assignment3.utils.Helper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebappServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener started");
        //new DefaultValidatorFactory().registerValidator("dioporco", "LocalDateValidator");
        Helper.dropDatabase();
        Helper.populateDatabase(2);
    }
}
