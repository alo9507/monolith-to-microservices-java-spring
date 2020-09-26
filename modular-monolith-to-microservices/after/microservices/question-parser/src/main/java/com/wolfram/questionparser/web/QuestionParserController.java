package com.wolfram.questionparser.web;

import com.wolfram.questionparser.model.ParsedQuestion;
import com.wolfram.questionparser.model.Question;
import com.wolfram.questionparser.service.QuestionParser;
import com.wolfram.questionparser.service.QuestionParserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/wolfram")
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
