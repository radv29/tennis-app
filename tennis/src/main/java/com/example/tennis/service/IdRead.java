package com.example.tennis.service;

import org.springframework.stereotype.Component;

@Component
public class IdRead {

    private String FirstId;
    private String SecondId;

    public IdRead() {
    }

    public String getFirstId() {
        return FirstId;
    }

    public void setFirstId(String firstId) {
        FirstId = firstId;
    }

    public String getSecondId() {
        return SecondId;
    }

    public void setSecondId(String secondId) {
        SecondId = secondId;
    }
}
