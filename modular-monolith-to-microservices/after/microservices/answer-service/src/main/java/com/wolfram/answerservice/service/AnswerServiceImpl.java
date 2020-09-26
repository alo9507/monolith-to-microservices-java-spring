package com.wolfram.answerservice.service;

import com.wolfram.answerservice.model.Answer;
import com.wolfram.answerservice.model.ParsedQuestion;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    public Answer answer(ParsedQuestion parsedQuestion) {
        return new Answer("Word count is: " + String.valueOf(parsedQuestion.tokens.size()));
    }
}
