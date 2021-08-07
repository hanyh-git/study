package com.hanyh.consumer.controller;

import com.hanyh.consumer.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
    @Autowired
    private HelloFeign helloFeign;

    @RequestMapping("/consumer/test")
    public String test() {
        return helloFeign.helloFeign("这是一个feign远程调用的结果");
    }

}
