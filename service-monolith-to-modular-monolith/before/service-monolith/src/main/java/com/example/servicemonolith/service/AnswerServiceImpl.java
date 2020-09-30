package com.example.servicemonolith.service;

import com.example.servicemonolith.model.Answer;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AnswerServiceImpl implements AnswerService {
    public Answer answer(List<String> tokens) {
        int wordCount = tokens.size();
        Answer answer = new Answer(String.valueOf(wordCount));
        return answer;
    }
}
