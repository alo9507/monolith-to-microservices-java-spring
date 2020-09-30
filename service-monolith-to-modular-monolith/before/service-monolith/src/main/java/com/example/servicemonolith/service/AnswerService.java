package com.example.servicemonolith.service;

import com.example.servicemonolith.model.Answer;

import java.util.List;

public interface AnswerService {
    public Answer answer(List<String> tokens);
}
