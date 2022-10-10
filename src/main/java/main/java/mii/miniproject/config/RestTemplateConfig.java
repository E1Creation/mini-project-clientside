package main.java.mii.miniproject.config;

import java.beans.BeanProperty;
import java.beans.JavaBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
   @Bean
   public RestTemplate restTemplate(){
    return new RestTemplate();
   }

}
