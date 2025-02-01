package com.OnceFactoriaF5.miemakeup.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter

public class ErrorResponse {
    private List<String> messages;
    int errorsNumber;
    private LocalDateTime timestamp;



    public ErrorResponse(List<String> messages, int errorsNumber) {
        this.messages = messages;
        this.errorsNumber = errorsNumber;
        this.timestamp = LocalDateTime.now();
    }
    public String getTimestamp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
        return timestamp.format(formatter);
    }
}
