package com.danh.assignment.thirdparty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO<T> {
	@JsonProperty("status")
    private String status;

    @JsonProperty("code")
    private int code;
    
    @JsonProperty("host")
    private String host;

    @JsonProperty("data")
    private T data;

    @JsonProperty("message")
    private String message;
}
