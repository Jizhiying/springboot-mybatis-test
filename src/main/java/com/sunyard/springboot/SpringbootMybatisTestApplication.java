package com.sunyard.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringbootMybatisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisTestApplication.class, args);
    }

}
