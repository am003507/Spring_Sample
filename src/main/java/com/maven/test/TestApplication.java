package com.maven.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.apache.log4j.Logger;



@SpringBootApplication
public class TestApplication {

    static Logger log = Logger.getLogger(TestApplication.class);

    public static void main(String[] args) {




        SpringApplication.run(TestApplication.class, args);
    }
}
