package com.example.demo.Listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created BY DarkSheep ON 2021/7/18 22:48
 **/
@WebListener
@Slf4j
public class ListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("ServletContext初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("ServletContext销毁");
    }
}
