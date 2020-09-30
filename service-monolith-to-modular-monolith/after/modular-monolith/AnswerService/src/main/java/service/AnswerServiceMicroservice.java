package service;

import model.Answer;
import model.ParsedQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("microservice")
public class AnswerServiceMicroservice implements AnswerService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Answer answer(ParsedQuestion parsedQuestion) {
        ResponseEntity<Answer> answerResponseEntity =
                restTemplate.postForEntity("http://localhost:8081/alpha/answer", parsedQuestion, Answer.class);

        return answerResponseEntity.getBody();
    }
}
