package com.javabuc17.exampleProject;

import com.javabuc17.exampleProject.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

//@SpringBootApplication               // el scaneaza toate clasele din package-ul curent si cel in care se afla
//@EnableWebMvc
public class ExampleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }


}
