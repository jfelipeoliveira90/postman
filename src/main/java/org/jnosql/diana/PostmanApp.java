package org.jnosql.diana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

@SpringBootApplication(exclude = EmbeddedMongoAutoConfiguration.class)
public class PostmanApp {

    public static void main(String[] args) {
        SpringApplication.run(PostmanApp.class, args);
    }
}
