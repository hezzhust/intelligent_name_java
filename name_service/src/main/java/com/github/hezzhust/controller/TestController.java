package com.github.hezzhust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;

/**
 * Created by hezz on 2017/8/25.
 */
@Controller
public class TestController implements Controller{


    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        return "helloworld";
    }

    public String value() {
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
