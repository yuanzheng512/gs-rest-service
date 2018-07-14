package hello.config;

import hello.controller.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ASUS on 2018/7/14.
 */
@Configuration
public class appConfig {

    @Bean
    public HelloService helloService(){
       return new HelloService();
    }
}
