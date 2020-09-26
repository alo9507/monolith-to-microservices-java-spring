package service;

import model.ParsedQuestion;
import model.Question;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@Profile("microservice")
public class QuestionParserMicroservice implements QuestionParser {
    @Override
    public ParsedQuestion parse(Question question) {
        return new ParsedQuestion((ArrayList<String>) Arrays.asList("fsdf"));
    }
}
