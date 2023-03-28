package com.api.translateapi.yandex;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "yandex")
public class YandexConfig {

    private String key;
}
