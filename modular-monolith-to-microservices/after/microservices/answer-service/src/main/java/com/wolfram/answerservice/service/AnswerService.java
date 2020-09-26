package com.wolfram.answerservice.service;

import com.wolfram.answerservice.model.Answer;
import com.wolfram.answerservice.model.ParsedQuestion;

public interface AnswerService {
    Answer answer(ParsedQuestion parsedQuestion);
}
