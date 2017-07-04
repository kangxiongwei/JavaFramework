package com.kxw.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kangxiongwei on 2017/7/4.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
