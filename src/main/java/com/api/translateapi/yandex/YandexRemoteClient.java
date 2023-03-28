package com.api.translateapi.yandex;

import com.api.translateapi.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "yandexRemoteClient",
        url = "https://translate.api.cloud.yandex.net/translate/v2",
        configuration = FeignConfig.class)

public interface YandexRemoteClient {

    @PostMapping(value = "/translate")
    YandexResponse.Response fetchTranslate(@RequestBody YandexRequest.TranslationRequest data);

}

