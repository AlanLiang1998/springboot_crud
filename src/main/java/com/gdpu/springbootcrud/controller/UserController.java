package com.gdpu.springbootcrud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.springbootcrud.entity.Employee;
import com.gdpu.springbootcrud.entity.User;
import com.gdpu.springbootcrud.service.IEmployeeService;
import com.gdpu.springbootcrud.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private IUserService userService;


    /**
     * 用户登录
     *
     * @param username   用户名
     * @param password   密码
     * @param session    保存用户名
     * @param attributes 保存提示信息
     * @return 成功返回首页视图，失败返回登录视图
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username).eq("password", password);
        User user = userService.getOne(wrapper);
        //logger.info(String.valueOf(user));
        if (user != null) {
            //登录成功
            session.setAttribute("username", user.getUserName());
            return "redirect:/main/1";
        } else {
            //登录失败
            attributes.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/";
        }
    }

    /**
     * 用户退出
     *
     * @param session 销毁session
     * @return 登录视图
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
