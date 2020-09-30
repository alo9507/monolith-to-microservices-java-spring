package service;

import model.ParsedQuestion;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("microservice")
public class QuestionParserMicroservice implements QuestionParser {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ParsedQuestion parse(Question question) {
        ResponseEntity<ParsedQuestion> parsedQuestionResponseEntity =
                restTemplate.postForEntity("http://localhost:8081/alpha/question", question, ParsedQuestion.class);

        return parsedQuestionResponseEntity.getBody();
    }
}
