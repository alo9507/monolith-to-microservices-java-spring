package service;

import model.Answer;
import model.ParsedQuestion;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("microservice")
public class AlphaServiceMicroservice implements AlphaService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Answer answer(Question question) {
        ResponseEntity<Answer> answerResponseEntity =
                restTemplate.postForEntity("http://localhost:8080/wolfram/alpha", question, Answer.class);

        return answerResponseEntity.getBody();
    }
}
