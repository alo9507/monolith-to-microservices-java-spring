package com.wolfram.monolith.web;

import com.wolfram.monolith.model.Answer;
import com.wolfram.monolith.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/alpha")
public class AlphaController {
    @PostMapping("/answer-question")
    public ResponseEntity<Answer> answerQuestion(@RequestBody Question question) {
        StringTokenizer defaultTokenizer = new StringTokenizer(question.question);
        List<String> tokens = new ArrayList<>();

        while (defaultTokenizer.hasMoreTokens()) {
            tokens.add(defaultTokenizer.nextToken());
        }

        int wordCount = tokens.size();
        Answer answer = new Answer(String.valueOf(wordCount));

        return new ResponseEntity(answer, HttpStatus.OK);
    }
}
