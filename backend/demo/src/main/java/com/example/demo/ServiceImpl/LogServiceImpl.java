package com.example.demo.ServiceImpl;

import com.example.demo.DAO.LogRepository;
import com.example.demo.Entity.Log;
import com.example.demo.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogServiceImpl implements LogService {
    private LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void saveLog(String level, String message, LocalDateTime time) {
        Log log = new Log(level,message,time);
        logRepository.save(log);
    }
}
