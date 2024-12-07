package com.example.Banking_App.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timeStamp,
                           String message,
                           String details,
                           String errorcode) {
}
