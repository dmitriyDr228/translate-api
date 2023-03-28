package com.api.translateapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Response")
@Builder
public class Response {

    @Id
    private Long id;

    private String translateParams;
    private String text;
    private String ipAddress;
    private String date;


}
