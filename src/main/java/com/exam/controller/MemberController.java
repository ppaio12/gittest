package com.exam.controller;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Member;

// user2 작업완료3
// user1 작업완료1
@Controller
@SessionAttributes(names = {"login"})
public class MemberController {

    Logger logger = LoggerFactory.getLogger(getClass());

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/idCheck")
    @ResponseBody
    public String idCheck(@RequestParam String userid) {
        MemberDTO dto = memberService.idCheck(userid);
        String mesg = "사용가능";

        if (dto != null) {
            mesg = "사용불가";
        }

        return mesg;
    }

    @GetMapping("/signup")
    public String singupForm(ModelMap modelMap) {
        MemberDTO dto = new MemberDTO();

        modelMap.addAttribute("memberDTO", dto);

        return "memberForm";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "memberForm";
        }

        logger.info("signup:{}", dto);
        int n = memberService.memberAdd(dto);

        return "redirect:main";
    }

    @GetMapping("/myPage")
    public String myPage(ModelMap model) {
        MemberDTO dto = (MemberDTO) model.getAttribute("login");

        String userid = dto.getUserid();

        MemberDTO searchDTO = memberService.myPage(userid);
        model.addAttribute("login", searchDTO);

        return "myPage";
    }

}
