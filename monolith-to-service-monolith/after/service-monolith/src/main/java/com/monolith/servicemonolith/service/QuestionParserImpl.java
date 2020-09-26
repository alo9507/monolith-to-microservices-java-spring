package com.monolith.servicemonolith.service;
import com.monolith.servicemonolith.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Component
public class QuestionParserImpl implements QuestionParser {
    public List<String> parseQuestion(Question question) {
        StringTokenizer defaultTokenizer = new StringTokenizer(question.question);
        List<String> tokens = new ArrayList<>();

        while (defaultTokenizer.hasMoreTokens()) {
            tokens.add(defaultTokenizer.nextToken());
        }
        return tokens;
    }
}
