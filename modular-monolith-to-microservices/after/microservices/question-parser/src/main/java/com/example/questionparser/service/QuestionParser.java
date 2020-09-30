package com.example.questionparser.service;

import com.example.questionparser.model.ParsedQuestion;
import com.example.questionparser.model.Question;

public interface QuestionParser {
    public ParsedQuestion parse(Question question);
}
