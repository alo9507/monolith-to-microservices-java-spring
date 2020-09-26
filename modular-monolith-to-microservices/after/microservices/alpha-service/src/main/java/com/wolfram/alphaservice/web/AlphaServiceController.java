package com.wolfram.alphaservice.web;

import com.wolfram.alphaservice.model.Answer;
import com.wolfram.alphaservice.model.ParsedQuestion;
import com.wolfram.alphaservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;

@RestController
@RequestMapping("/wolfram")
public class AlphaServiceController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaProducer<String,String> kafkaProducer;

    @Value("${service.answer-service}")
    private String answerService;

    @Value("${service.question-service}")
    private String questionParser;

    @RequestMapping(value="/alpha",method= RequestMethod.POST)
    public Answer alphaAnswer(@RequestBody Question question) {
        // Send question to Kafka topic for question monitoring
        try {
            kafkaProducer.send(new ProducerRecord<String, String>("questions", question.question));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Contact QuestionParser Microservice
        ResponseEntity<ParsedQuestion> parsedQuestionResponseEntity =
                restTemplate.postForEntity("http://"+questionParser+"/wolfram/question", question, ParsedQuestion.class);
        ParsedQuestion parsedQuestion = parsedQuestionResponseEntity.getBody();

        // Contact AnswerService Microservice
        ResponseEntity<Answer> answerResponseEntity =
                restTemplate.postForEntity("http://"+answerService+"/wolfram/answer", parsedQuestion, Answer.class);

        return answerResponseEntity.getBody();
    }
}
