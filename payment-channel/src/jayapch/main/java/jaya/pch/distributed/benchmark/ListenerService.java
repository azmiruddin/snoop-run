package main.java.jaya.pch.distributed.benchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ListenerService extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ListenerService.class, args);
    }

}

//public class ListenerService {
//
//}