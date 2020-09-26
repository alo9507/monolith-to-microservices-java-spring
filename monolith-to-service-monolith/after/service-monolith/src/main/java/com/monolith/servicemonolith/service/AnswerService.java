package com.monolith.servicemonolith.service;

import com.monolith.servicemonolith.model.Answer;

import java.util.List;

public interface AnswerService {
    public Answer answer(List<String> tokens);
}
