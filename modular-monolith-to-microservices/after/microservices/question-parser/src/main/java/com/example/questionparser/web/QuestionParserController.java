package com.example.questionparser.web;

import com.example.questionparser.service.QuestionParser;
import com.example.questionparser.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/alpha")
public class QuestionParserController {
    @Autowired
    QuestionParser questionParser;

    @RequestMapping(value = "/question", method = POST)
    public ResponseEntity<List<String>> tokenizeQuestion(@RequestBody Question question) {

        try {
            return new ResponseEntity(questionParser.parse(question), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
}
