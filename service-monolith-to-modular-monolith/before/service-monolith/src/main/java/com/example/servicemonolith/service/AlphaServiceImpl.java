package com.example.servicemonolith.service;

import com.example.servicemonolith.model.Answer;
import com.example.servicemonolith.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlphaServiceImpl implements AlphaService {
    @Autowired
    QuestionParser questionParser;

    @Autowired
    AnswerService answerService;

    public Answer answer(Question question) {
        List<String> tokens = questionParser.parseQuestion(question);
        Answer answer = answerService.answer(tokens);
        return answer;
    }
}
