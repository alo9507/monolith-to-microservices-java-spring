package com.example.servicemonolith.service;

import com.example.servicemonolith.model.Answer;
import com.example.servicemonolith.model.Question;

public interface AlphaService {
    Answer answer(Question question);
}
