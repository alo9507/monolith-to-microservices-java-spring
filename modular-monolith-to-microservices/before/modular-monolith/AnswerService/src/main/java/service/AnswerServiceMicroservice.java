package service;

import model.Answer;
import model.ParsedQuestion;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("microservice")
public class AnswerServiceMicroservice implements AnswerService {
    @Override
    public Answer answer(ParsedQuestion parsedQuestion) {
        return new Answer("fsd");
    }
}
