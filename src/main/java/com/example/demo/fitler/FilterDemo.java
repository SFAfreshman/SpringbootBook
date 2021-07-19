package com.example.demo.fitler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created BY DarkSheep ON 2021/7/17 19:29
 * #### 第七章第三节: 过滤器与监听器
 * 编写过滤器类后需要在SpringBoot入口类中添加`@ServletComponentScan` 注册Filter
 * 自定义Servlet 处理时也需要使用本注解
 *  > 如需要所有接口中过滤非法字符时
 *  * 前端页面参数传入时进行校验,过滤非法字符
 *  * 前端不校验 后端接收并校验,过滤非法字符
 *  > 则每次都需要处理
 *  > 可以使用过滤器对所有接口进行过滤处理
 *
 **/
//@Order(1)//序号越小,越早执行
//@WebFilter(urlPatterns = "/*")
    /*
    * @WebFilter(urlPatterns = "/*")注解会导致启动springboot失败
    * Unable to start embedded Tomcat*/
@Slf4j
//implements Filter  :javax.servlet.Filter
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //服务器启动时初始化
        log.info("Filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //request处理逻辑
        //request封装逻辑
        //chain 重新返回request和response
        log.info("拦截器");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        //服务器关闭时执行
        log.info("Filter执行 destroy");
    }
}
