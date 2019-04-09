package com.yzj.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = { "com.yzj.music.*" })
@EnableTransactionManagement
public class SpringbootMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMusicApplication.class, args);
    }

}

