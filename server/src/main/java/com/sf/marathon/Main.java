package com.sf.marathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableScheduling
public class Main {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
