package com.coluzzi.kankan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {


    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

}
