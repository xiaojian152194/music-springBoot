package com.yzj.music.controller;

import com.yzj.music.commons.CommonParameters;
import com.yzj.music.commons.OperateInfo;
import com.yzj.music.commons.ResponseRange;
import com.yzj.music.commons.contants.Contants;
import com.yzj.music.commons.exception.MusicException;
import com.yzj.music.entity.User;
import com.yzj.music.service.ILoginService;
import com.yzj.music.service.IMusicService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "/user" })
public class LoginController {
    @javax.annotation.Resource(name = "com.yzj.music.LoginService")
    private ILoginService loginService;
    @javax.annotation.Resource(name = "com.yzj.music.MusicService")
    private IMusicService musicService;

    @RequestMapping(value = { "getUser" }, method = { RequestMethod.GET })
    @ResponseBody
    public ResponseRange<User> getUser(CommonParameters commonParameters, HttpServletRequest request) {
        ResponseRange<User> responseRange = new ResponseRange<>();
        try {
            if (request.getSession().getAttribute(Contants.LOGIN_PROVE_FG) != null) {
                responseRange.setData((User) request.getSession().getAttribute(Contants.LOGIN_PROVE_FG));
            } else if (request.getSession().getAttribute(Contants.LOGIN_PROVE_BG) != null) {
                responseRange.setData((User) request.getSession().getAttribute(Contants.LOGIN_PROVE_BG));
            } else {
                throw new MusicException("用户尚未登录");
            }
        } catch (Exception e) {
            responseRange.setException(e);
        }
        return responseRange;
    }
    @RequestMapping(value = { "login" }, method = { RequestMethod.POST })
    @ResponseBody
    public ResponseRange<User> login(CommonParameters commonParameters, @RequestBody User user, HttpServletRequest request) {
        ResponseRange<User> responseRange = new ResponseRange<>();
        try {
            if (user == null || user.selfIsNull() || user.getUsername().equals("") || user.getPassword().equals("")) {
                throw new MusicException("用户名或密码不能为空！");
            }
            user = loginService.login(user);
            if(user.getHaveAuthority().equals(Contants.YesOrTrue)){
                responseRange.setRoles("admin");
//                responseRange.setRequestId(Contants.LOGIN_PROVE_BG);
                request.getSession().setAttribute(Contants.LOGIN_PROVE_BG, user);
            }
            else{
                responseRange.setRoles("user");
//                responseRange.setRequestId(Contants.LOGIN_PROVE_FG);
                request.getSession().setAttribute(Contants.LOGIN_PROVE_FG, user);
            }
            responseRange.setData(user);
        } catch (Exception e) {
            responseRange.setException(e);
        }
        return responseRange;
    }
    @RequestMapping(value = { "register" }, method = { RequestMethod.POST })
    @ResponseBody
    public ResponseRange<User> register(CommonParameters commonParameters, @RequestBody User user) {
        ResponseRange<User> responseRange = new ResponseRange<>();
        try {
            if (user == null || user.selfIsNull() || user.getUsername().equals("") || user.getPassword().equals("")) {
                throw new MusicException("必填项不能为空！");
            }
            user.setCreateDate(System.currentTimeMillis());
            user = loginService.register(user);
            responseRange.setData(user);
        } catch (Exception e) {
            responseRange.setException(e);
        }
        return responseRange;
    }
    @RequestMapping(value = { "logout" }, method = { RequestMethod.POST })
    @ResponseBody
    public ResponseRange<User> logout(CommonParameters commonParameters, HttpServletRequest request) {
        ResponseRange<User> responseRange = new ResponseRange<>();
        try {
            request.getSession().removeAttribute(Contants.LOGIN_PROVE_FG);
            request.getSession().removeAttribute(Contants.LOGIN_PROVE_BG);
        } catch (Exception e) {
            responseRange.setException(e);
        }
        return responseRange;
    }
}
