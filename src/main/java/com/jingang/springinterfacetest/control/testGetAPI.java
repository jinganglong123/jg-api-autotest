package com.jingang.springinterfacetest.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Slf4j
public class testGetAPI {
    @GetMapping("/hello")
    public String hello(){
        log.info("control--info:hello");

        return "hello world!! jg-api-autotest";


    }


}
