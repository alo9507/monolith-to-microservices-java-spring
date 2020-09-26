package com.monolith.servicemonolith.web;

import com.monolith.servicemonolith.model.Answer;
import com.monolith.servicemonolith.model.Question;
import com.monolith.servicemonolith.service.AnswerService;
import com.monolith.servicemonolith.service.QuestionParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/alpha")
public class WolframController {
    @Autowired
    QuestionParser questionParser;

    @Autowired
    AnswerService answerService;

    @PostMapping("/answer")
    public Answer answerQuestion(@RequestBody Question question) {
        List<String> tokens = questionParser.parseQuestion(question);
        Answer answer = answerService.answer(tokens);
        return answer;
    }
}
