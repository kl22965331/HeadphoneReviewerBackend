package com.example.demo.Service;

import java.time.LocalDateTime;

public interface LogService {
    public void saveLog(String level, String message, LocalDateTime time);
}
