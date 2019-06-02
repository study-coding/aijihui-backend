package com.ajh.aijihui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.ajh.aijihui.mapper")
@SpringBootApplication
public class AijihuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AijihuiApplication.class, args);
    }

}
