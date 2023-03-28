package com.api.translateapi.yandex;

import java.util.List;

public interface YandexRequest {


    record TranslationRequest(String sourceLanguageCode,
                              String targetLanguageCode,
                              String format,
                              List<String> texts) {
        TranslationRequest(String sourceLanguageCode, String targetLanguageCode,
                           List<String> texts) {
            this(sourceLanguageCode, targetLanguageCode, "PLAIN_TEXT", texts);
        }
    }

}
