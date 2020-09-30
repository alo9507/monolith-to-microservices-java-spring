package com.example.answerservice.service;

import com.example.answerservice.model.Answer;
import com.example.answerservice.model.ParsedQuestion;

public interface AnswerService {
    Answer answer(ParsedQuestion parsedQuestion);
}
