package com.monolith.servicemonolith.service;

import com.monolith.servicemonolith.model.Answer;
import com.monolith.servicemonolith.model.Question;

public interface AlphaService {
    Answer answer(Question question);
}
