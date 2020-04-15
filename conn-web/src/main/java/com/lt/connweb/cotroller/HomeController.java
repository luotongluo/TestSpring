package com.lt.connweb.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tong.luo
 * @description TestCOntroller
 * @date 2020/4/11 16:05
 */
@Controller
public class HomeController {

    @RequestMapping(value={"", "/", "/index", "/index/"})
    public String home(Model model) {
        System.out.println("1223123");
        model.addAttribute("test",123);
    return "home.ftl";
    }
}