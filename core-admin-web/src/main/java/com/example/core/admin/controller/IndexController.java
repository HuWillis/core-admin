package com.example.core.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huyong
 * @version 1.0
 * {@code @project} core-admin
 * {@code @date} 2024/9/30 21:47
 * {@code @description:} 视图控制器
 */
@Controller
public class IndexController {
    /**
     * 跳转到首页
     *
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping({"/index/login", "/login", "/"})
    public String loginIndex() {
        return "auth/login";
    }

    /**
     * 跳转到错误页面
     * @return 403
     */
    @GetMapping("/error/403")
    public String error403() {
        return "error/403";
    }

    /**
     * 跳转到错误页面
     * @return 404
     */
    @GetMapping("/error/404")
    public String error404() {
        return "error/404";
    }

}
