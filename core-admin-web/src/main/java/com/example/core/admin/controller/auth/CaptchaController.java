package com.example.core.admin.controller.auth;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author hy
 * @title: CaptchaController
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-22 10:31:36 10:31
 */
@RestController
@RequestMapping("/auth/captcha")
@RequiredArgsConstructor
@Tag(name = "验证码接口")
@SessionAttributes("captcha")
public class CaptchaController {

    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;
    private static final int CODE_COUNT = 4;

    /**
     * 获取验证码
     *
     * @param session session
     * @return ResponseEntity < byte[] >
     * @throws IOException io
     */
    @GetMapping("/captcha")
    @Operation(summary = "获取验证码")
    public ResponseEntity<byte[]> getCaptcha(HttpSession session) throws IOException {
        // 创建验证码对象
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(WIDTH, HEIGHT, CODE_COUNT, 10);

        // 将验证码放入 session
        session.setAttribute("captcha", lineCaptcha.getCode());

        // 将验证码图片转换为字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        lineCaptcha.write(baos);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return ResponseEntity.ok().headers(headers).body(baos.toByteArray());
    }


}
