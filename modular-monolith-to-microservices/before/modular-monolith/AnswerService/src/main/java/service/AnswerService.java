package service;

import model.Answer;
import model.ParsedQuestion;

import java.util.List;

public interface AnswerService {
    public Answer answer(ParsedQuestion parsedQuestion);
}
