package com.czxy.imterceptor;

import com.czxy.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Userlnterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        System.out.println(path);
        //静态页放行
        if (path.startsWith("/css")||path.startsWith("/js")||path.startsWith("/images")){
            return true;
        }

        if (path.startsWith("/user/login")||path.startsWith("/login.html")){
            return true;
        }

        if (path.startsWith("/welcome.html")){
            User user = (User) request.getSession().getAttribute("user");
            if (user==null){
                response.sendRedirect("/login.html");
                return false;
            }else {
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
