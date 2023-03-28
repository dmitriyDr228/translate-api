package com.api.translateapi.repos;

import com.api.translateapi.dto.Response;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepo {

    List<Response> getALl();
    Response findResponseById(Long id);
    int save(Response response);
}
