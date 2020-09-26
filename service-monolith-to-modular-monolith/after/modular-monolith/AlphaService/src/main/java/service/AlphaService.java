package service;

import model.Answer;
import model.ParsedQuestion;
import model.Question;

import java.util.List;

public interface AlphaService {
    public Answer answer(Question question);
}
