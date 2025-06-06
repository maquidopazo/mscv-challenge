package com.challenge.mscv_challenge.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse <T> {
    private Integer httpCode;
    private HttpStatus httpMessage;
    private String moreInformation;
    private String userFriendlyError;
    private LocalDateTime localDateTime;
    private T response;

    public RestResponse(){
        this.localDateTime = LocalDateTime.now();
    }

    public RestResponse(HttpStatus status){
        this();
        this.httpCode = 200;
        this.httpMessage = HttpStatus.OK;
        this.localDateTime = LocalDateTime.now();
    }

    public RestResponse(T response){
        this();
        this.httpCode = 200;
        this.httpMessage = HttpStatus.OK;
        this.response = response;
    }
    public RestResponse(T response, HttpStatus status){
        this();
        this.httpCode = status.value();
        this.httpMessage = status;
        this.response = response;
    }
}

