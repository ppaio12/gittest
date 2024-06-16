package com.exam.controller;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes(names = {"login"})
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());

    MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("login")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("login")
    public String login(@RequestParam Map<String, String> m, ModelMap model) {
        MemberDTO dto = memberService.login(m);

        // 로그인이 되었다면
        if (dto != null) {
            model.addAttribute("login", dto);
            return "redirect:main";
        }

        // 로그인이 되지 않았다면
        model.addAttribute("errorMessage", "아이디 및 비번 확인 필요");
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:main";
    }
}
