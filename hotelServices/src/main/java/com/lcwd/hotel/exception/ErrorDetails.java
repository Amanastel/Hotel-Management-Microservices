package com.lcwd.hotel.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private String message;
    private LocalDateTime timeStamp;
    private String uri;


}
