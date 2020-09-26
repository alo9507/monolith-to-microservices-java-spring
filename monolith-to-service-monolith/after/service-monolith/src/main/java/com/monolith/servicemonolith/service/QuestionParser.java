package com.monolith.servicemonolith.service;

import com.monolith.servicemonolith.model.Question;
import java.util.List;

public interface QuestionParser {
    public List<String> parseQuestion(Question question);
}
