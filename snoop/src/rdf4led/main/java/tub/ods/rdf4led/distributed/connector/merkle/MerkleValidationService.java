package tub.ods.rdf4led.distributed.connector.merkle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VerifyApp {

    public static void main(String[] args) {
        SpringApplication.run(VerifyApp.class, args);
    }

    @Bean
    RestTemplate rest() {
        return new RestTemplate();
    }

}
