package com.monolith.servicemonolith.web;

import com.monolith.servicemonolith.model.Answer;
import com.monolith.servicemonolith.model.Question;
import com.monolith.servicemonolith.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    AlphaService alphaService;

    @PostMapping("/answer-question")
    public ResponseEntity<Answer> answerQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity(alphaService.answer(question), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
}
