package com.example.answerservice.web;

import com.example.answerservice.model.Answer;
import com.example.answerservice.service.AnswerService;
import com.example.answerservice.model.ParsedQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/alpha")
public class AnswerServiceController {
    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "/answer", method = POST)
    public Answer getAnswer(@RequestBody ParsedQuestion parsedQuestion) {
        return answerService.answer(parsedQuestion);
    }
}
