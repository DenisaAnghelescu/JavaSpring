package com.javabuc17.exampleProject.config;


import com.javabuc17.exampleProject.repositories.ClassRoomRepository;
import com.javabuc17.exampleProject.services.ClassRoomServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Locale;

@SpringBootApplication
// --->
// el scaneaza toate clasele din package-ul curent si cel in care se afla

@ComponentScan("com.javabuc17.exampleProject")
// pentru a-l ajuta sa gaseasca clasele, unde sa scaneze

@EnableJpaRepositories("com.javabuc17.exampleProject.repositories")
// intantierea interfetelor de repository + locatie

@Configuration
// arata ca asta e clasa de configurare, si trebuie citita la pornire
// ii spunem sa ne creeze repositori cu care sa ne lege la DB folosind acest package("com.javabuc17... . repositories")  la fel ca sus

@EntityScan("com.javabuc17.exampleProject.models")
// instantiere  +  conectarea cu DB

@EnableWebMvc
// pt scan controller


//@Import({WebSec.class, ...class, Asdasffas.class ...})
// alte clase de configurare
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }
    /*@Bean*/
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/message");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);
        return resolver;
    }

//    @Bean("classRoomServiceFromBean")
//    public ClassRoomServiceImpl createClassRoom(ClassRoomRepository classRoomRepository) {
//        return new ClassRoomServiceImpl(classRoomRepository);
//    }
//
//    @Bean("classRoomServiceFromBean2")
//    @DependsOn("templateResolver")
//    // @Bean("classRoomServiceFromBean2") poate fi creat doar daca exista acest templateResolver a fost instantiat de Spring
//    public ClassRoomServiceImpl createClassRoom1(ClassRoomRepository classRoomRepository) {
//        return new ClassRoomServiceImpl(classRoomRepository);
//    }
}
