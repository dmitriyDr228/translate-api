package com.api.translateapi.yandex;

import java.util.List;

public interface TranslationService {

    List<String> translate(String fromLang, String toLang, String data);

}
