package com.maven.test.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class MybatisController {



    @RequestMapping(value="/db",method=RequestMethod.GET)
    public String get_db(){




    }






}
