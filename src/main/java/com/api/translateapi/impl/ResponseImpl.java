package com.api.translateapi.impl;

import com.api.translateapi.dto.Response;
import com.api.translateapi.repos.ResponseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseImpl implements ResponseRepo {

    private final String FIND_ALL = "SELECT * FROM Response";
    private final String FIND_BY_ID = "SELECT * FROM Response WHERE ID = ? ";
    private final String INSERT_RESPONSE = "INSERT INTO  Response(translate_params, text, ip_address, date) VALUES (?,?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Response> getALl() {
        return jdbcTemplate
                .query(FIND_ALL, BeanPropertyRowMapper.newInstance(Response.class));
    }

    @Override
    public Response findResponseById(Long id) {
        return jdbcTemplate
                .queryForObject(FIND_BY_ID, new Object[]{id},
                        BeanPropertyRowMapper.newInstance(Response.class));
    }

    @Override
    public int save(Response response) {

        return jdbcTemplate.update(INSERT_RESPONSE,
                response.getTranslateParams(),
                response.getText(),
                response.getIpAddress(),
                String.valueOf(LocalDate.now()));
    }

}
