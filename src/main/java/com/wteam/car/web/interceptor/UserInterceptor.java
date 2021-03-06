package com.wteam.car.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wteam.car.bean.interact.response.Msg;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor extends HandlerInterceptorAdapter {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print((new ObjectMapper()).writeValueAsString(Msg.authority("请先登录")));
            return false;
        } else {
            return true;
        }
    }

}
