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

    @GetMapping({"/index/login", "/login", "/"})
    public String loginIndex() {
        return "login";
    }
}
