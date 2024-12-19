package com.example.bookstore.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class testController {
    @Value("${app.version}")
    private String appVersions;


    @RequestMapping("/app")
    public Map getstatus(){
        Map map = new HashMap<String,String>();
        map.put("app Version",appVersions);
        return map;
    }


}
