package com.chaokunyang.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaokunyang
 * @create 2017/3/1
 */
@RestController
@SpringBootApplication
public class Application {

    @GetMapping("/")
    public String home() {
        return "spring boot gradle docker";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
