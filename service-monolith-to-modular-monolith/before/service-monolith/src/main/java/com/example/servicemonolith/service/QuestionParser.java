package com.example.servicemonolith.service;

import com.example.servicemonolith.model.Question;

import java.util.List;

public interface QuestionParser {
    public List<String> parseQuestion(Question question);
}
