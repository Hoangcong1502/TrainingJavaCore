package edu.hanoi;

import edu.hanoi.jazz.ContextStartEventHandler;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class Application {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(Application.class, args);
    }

}
