package com.zsw.spring.boot.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author Administrator on 2019/9/15 12:53
 **/
@Slf4j
@Configuration
//@EnableAutoConfiguration
//@SpringBootApplication
public class WebConfiguration {

    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/hello-world"),
                request -> ok().body(Mono.just("Hello World!"), String.class));
    }


    @Bean
    public ApplicationRunner applicationRunner(BeanFactory beanFactory) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                log.info("当前 helloWorld Bean 实现类为：{}", beanFactory.getBean("helloWorld").getClass().getName());
                log.info("当前 WebConfiguration Bean 的实现类为：{}", beanFactory.getBean(WebConfiguration.class).getClass().getName());
            }
        };
//        return args -> System.out.println(applicationContext.getWebServer().getClass());
    }


    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        log.info("当前 WebServer 实现类为：{}", event.getWebServer().getClass());
    }

}
