package com.api.translateapi.controller;

import com.api.translateapi.dto.Request;
import com.api.translateapi.dto.Response;
import com.api.translateapi.impl.RequestImpl;
import com.api.translateapi.impl.ResponseImpl;
import com.api.translateapi.yandex.YandexTranslationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/translate")

public class FirstController {

    private final ResponseImpl responseService;
    private final RequestImpl requestService;

    private final YandexTranslationService translationService;

    public FirstController(ResponseImpl responseService,
                           RequestImpl requestService,
                           YandexTranslationService translationService) {
        this.responseService = responseService;
        this.requestService = requestService;
        this.translationService = translationService;
    }

    @PostMapping
    public ResponseEntity<?> sendTranslate(HttpServletRequest httpRequest,
                                           @RequestBody Request request) throws IOException {

        requestService.save(request);
        List<String> translate =
                translationService.
                        translate(request.getLanguage(), request.getText());
        responseService.save(
               Response.builder()
                       .text(String.valueOf(translate))
                       .translateParams(request.getLanguage())
                       .date(String.valueOf(LocalDateTime.now()))
                       .ipAddress(httpRequest.getRemoteAddr())
                       .build()
        );

        return ResponseEntity
                .ok(translate);
    }

}
