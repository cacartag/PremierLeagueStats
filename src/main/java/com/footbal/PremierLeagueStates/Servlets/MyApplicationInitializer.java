package com.footbal.PremierLeagueStates.Servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Array;
import java.util.ArrayList;

@Controller
public class MyApplicationInitializer {

    @GetMapping("/Hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        ArrayList<String> multi = new ArrayList<>();

        multi.add("First");
        multi.add("Second");

        model.addAttribute("name", name);
        model.addAttribute("multi", multi);
        return "greeting";
    }

}
