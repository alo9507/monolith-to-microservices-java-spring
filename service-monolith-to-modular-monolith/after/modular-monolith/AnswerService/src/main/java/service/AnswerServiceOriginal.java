package service;

import model.Answer;
import model.ParsedQuestion;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class AnswerServiceOriginal implements AnswerService {

    @Override
    public Answer answer(ParsedQuestion parsedQuestion) {
        return new Answer("Original AlphaService says - Word count is "+String.valueOf(parsedQuestion.tokens.size()));
    }
}
