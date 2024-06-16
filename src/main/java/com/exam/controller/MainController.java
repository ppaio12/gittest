package com.exam.controller;

import com.exam.dto.GoodsDTO;
import com.exam.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(getClass());

    GoodsService service;

    public MainController(GoodsService service) {
        this.service = service;
    }

    // 깃 테스트 1번 진행
    // user2 작업 완료
    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "top") String gCategory, ModelMap model) {

        List<GoodsDTO> goodsList = service.goodsList(gCategory);

        model.addAttribute("goodsList", goodsList);

        return "main";
    }



}
