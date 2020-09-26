package service;

import model.Answer;
import model.ParsedQuestion;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("default")
public class AlphaServiceOriginal implements AlphaService {

    @Autowired
    QuestionParser questionParser;

    @Autowired
    AnswerService answerService;

    @Override
    public Answer answer(Question question) {
        ParsedQuestion parsedQuestion = questionParser.parse(question);
        return answerService.answer(parsedQuestion);
    }
}
