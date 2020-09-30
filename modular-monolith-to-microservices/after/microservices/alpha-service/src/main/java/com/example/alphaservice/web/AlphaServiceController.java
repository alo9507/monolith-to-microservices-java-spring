package com.example.alphaservice.web;

import com.example.alphaservice.model.Answer;
import com.example.alphaservice.model.ParsedQuestion;
import com.example.alphaservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/alpha")
public class AlphaServiceController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.answer-service}")
    private String answerService;

    @Value("${service.question-service}")
    private String questionParser;

    @RequestMapping(value="/answer-question",method= RequestMethod.POST)
    public Answer alphaAnswer(@RequestBody Question question) {
        // Contact QuestionParser Microservice
        ResponseEntity<ParsedQuestion> parsedQuestionResponseEntity =
                restTemplate.postForEntity("http://" + questionParser + "/alpha/question", question, ParsedQuestion.class);
        ParsedQuestion parsedQuestion = parsedQuestionResponseEntity.getBody();

        // Contact AnswerService Microservice
        ResponseEntity<Answer> answerResponseEntity =
                restTemplate.postForEntity("http://" + answerService + "/alpha/answer", parsedQuestion, Answer.class);

        return answerResponseEntity.getBody();
    }
}
