package com.monolith.servicemonolith.service;

import com.monolith.servicemonolith.model.Answer;
import com.monolith.servicemonolith.model.Question;
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
