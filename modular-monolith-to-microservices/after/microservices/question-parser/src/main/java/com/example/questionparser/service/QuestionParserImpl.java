package com.example.questionparser.service;

import com.example.questionparser.model.ParsedQuestion;
import com.example.questionparser.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.StringTokenizer;

@Service
public class QuestionParserImpl implements QuestionParser {
    public ParsedQuestion parse(Question question) {
        StringTokenizer stringTokenizer = new StringTokenizer(question.question);

        ArrayList<String> tokens = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }

        return new ParsedQuestion(tokens);
    }
}
