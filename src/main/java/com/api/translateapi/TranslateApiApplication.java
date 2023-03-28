package com.api.translateapi;

import com.api.translateapi.yandex.TranslationService;
import com.api.translateapi.yandex.YandexConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(YandexConfig.class)
@EnableFeignClients
public class TranslateApiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(TranslateApiApplication.class, args);
    }

}
