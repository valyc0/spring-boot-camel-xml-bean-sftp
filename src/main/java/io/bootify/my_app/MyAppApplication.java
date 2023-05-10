package io.bootify.my_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:app-camel.xml")
public class MyAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
    }

}
