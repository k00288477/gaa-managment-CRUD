package org.gaaclubmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class GaaClubManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaaClubManagementSystemApplication.class, args);
    }
//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .allowCredentials(true);
//    }

}
