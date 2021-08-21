package com.vn.controller.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/logoutOK", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        return "logOut";
    }

    @GetMapping("/deniedPage")
    public String deniedPage(Model model) {
        model.addAttribute("message", "Đăng nhập không đúng vai trò");
        return "loginPage";
    }
    
    @GetMapping("/loginerror")
    public String saiUser(Model model ,RedirectAttributes attributes) {
        model.addAttribute("message", "Đăng nhập sai tên tài khoản hoặc mật khẩu");
        return "loginPage";
    }
    
    @GetMapping("/loginSuccess")
    public String loginsucces(Model model) {
    	Authentication info = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("xinchao" , "Xin chào : " + info.getName());
    	model.addAttribute("info", info);
        return "loginSuccess";
    }

}