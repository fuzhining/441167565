package com.czxy.controller;
import	java.lang.reflect.Type;
import java.io.IOException;
import	java.nio.file.Path;
import	java.net.HttpURLConnection;
import	java.nio.file.attribute.UserPrincipal;
import	java.net.URL;
import	java.lang.annotation.RetentionPolicy;
import	java.lang.annotation.Retention;


import com.czxy.domain.AjaxResult;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserServlet {

    @Resource
    private UserService userService;


    @PostMapping("login")
    public ResponseEntity<AjaxResult>login(User user,HttpServletRequest request){
        try {
            AjaxResult ajaxResult=new AjaxResult();
            User loginU = userService.findUserByUser(user);
            if (loginU==null){
                ajaxResult.setFlag(false);
                ajaxResult.setMsg("用户名错误");
            }else {
                ajaxResult.setFlag(true);
                request.getSession().setAttribute("user",loginU);
            }
            return new ResponseEntity<>(ajaxResult,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("register")
    public ResponseEntity<Void>register(User user){
        try {
            AjaxResult ajaxResult=new AjaxResult();
            User user1 = userService.findUserByName(user.getUsername());
            if (user1==null){
                userService.insertUser(user);
                ajaxResult.setFlag(true);
            }else {
                ajaxResult.setFlag(false);
                ajaxResult.setMsg("用户名存在");
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getlogin")
    public ResponseEntity<Void>getlogin(HttpServletRequest request){
        try {
            AjaxResult ajaxResult=new AjaxResult();
            User user = (User) request.getSession().getAttribute("user");
            if (user==null){
                ajaxResult.setFlag(false);
                ajaxResult.setMsg("请登录");
            }else {
                ajaxResult.setFlag(true);
                ajaxResult.setObject(user);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("loginout")
    public ResponseEntity<Void>logOut(HttpServletRequest request){
        try {
            AjaxResult ajaxResult=new AjaxResult();
            request.getSession().removeAttribute("user");
            ajaxResult.setFlag(true);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
