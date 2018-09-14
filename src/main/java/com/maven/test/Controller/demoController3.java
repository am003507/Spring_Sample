package com.maven.test.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class demoController3 {




    @RequestMapping(value="/api/user3",method= RequestMethod.GET)

    public String dd(){

        return "test";

    }

}
