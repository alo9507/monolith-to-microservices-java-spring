package service;

import model.ParsedQuestion;
import model.Question;

public interface QuestionParser {
    public ParsedQuestion parse(Question question);
}
