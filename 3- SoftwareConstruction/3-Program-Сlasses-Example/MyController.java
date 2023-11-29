package com.example.blazkolab9.controller;

import com.example.blazkolab9.model.SafeLightBot;
import com.example.blazkolab9.service.SafeLightBotService;
import com.example.blazkolab9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    private SafeLightBotService SafeLightBotService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String login() {
        return "main-page";
    }


    @PostMapping("/light-info")
    public String airStateInfo(@RequestParam String username, @RequestParam String location, Model model) {

        SafeLightBot SafeLightBot = new SafeLightBotService();
        String lightInfo = safeLightBot.checkLight(username, location);
        model.addAttribute("lightInfo", lightInfo);

        return "light-info";
    }

}
