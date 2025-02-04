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
    private int errorsNumber;
    private LocalDateTime timestamp;



    public ErrorResponse(List<String> messages) {
        this.messages = messages;
        this.errorsNumber = messages.size();
        this.timestamp = LocalDateTime.now();
    }
    public String getTimestamp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
        return timestamp.format(formatter);
    }
}
