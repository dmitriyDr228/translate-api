package com.api.translateapi.impl;

import com.api.translateapi.dto.Request;
import com.api.translateapi.repos.RequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestImpl implements RequestRepo {

    private String FIND_ALL = "SELECT * FROM Request ";
    private String SAVE = "INSERT INTO Request (language, text) VALUES(?,?)";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Request> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Request.class));
    }

    @Override
    public int save(Request request) {

        return jdbcTemplate.update(SAVE, request.getLanguage(),request.getText());
    }
}
