package com.ksoft.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.ksoft.constant.ServerConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class LoginController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index() {

        return "login/index";
    }

    /**
     * 生成验证码
     *
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/img/code")
    public StreamingResponseBody getCaptcha(HttpServletResponse response, HttpSession session) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String code = defaultKaptcha.createText();
        session.setAttribute(ServerConstant.SESSION_KEY_KAPTCHA, code);
        final BufferedImage image = defaultKaptcha.createImage(code);
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                ImageIO.write(image, "jpg", outputStream);
            }
        };
    }

}
