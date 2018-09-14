package com.maven.test.Controller;


import com.maven.test.Service.USer;
import com.maven.test.Service.UserMapper;
import com.maven.test.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class DemoController2 {




//    @RequestMapping(value="/user",method= RequestMethod.GET)
//    public List<USer> dd(){
//
//
//
//        return usermapper.findAll();
//    }
}
