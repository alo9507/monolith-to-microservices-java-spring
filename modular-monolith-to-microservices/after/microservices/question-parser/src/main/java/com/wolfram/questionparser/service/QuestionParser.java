package com.wolfram.questionparser.service;

import com.wolfram.questionparser.model.ParsedQuestion;
import com.wolfram.questionparser.model.Question;
import org.springframework.stereotype.Service;

public interface QuestionParser {
    public ParsedQuestion parse(Question question);
}
