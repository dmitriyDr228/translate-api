package com.api.translateapi.repos;

import com.api.translateapi.dto.Request;
import com.api.translateapi.dto.Response;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepo {

    List<Request> findAll();

    int save(Request request);


}
