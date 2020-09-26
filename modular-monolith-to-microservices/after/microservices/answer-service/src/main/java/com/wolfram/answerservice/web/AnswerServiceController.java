package com.wolfram.answerservice.web;

import com.wolfram.answerservice.model.Answer;
import com.wolfram.answerservice.model.ParsedQuestion;
import com.wolfram.answerservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/wolfram")
public class AnswerServiceController {
    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "/answer", method = POST)
    public Answer getAnswer(@RequestBody ParsedQuestion parsedQuestion) {
        return answerService.answer(parsedQuestion);
    }
}
