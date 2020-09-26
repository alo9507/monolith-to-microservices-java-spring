package service;

import model.ParsedQuestion;
import model.Question;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.StringTokenizer;

@Component
@Profile("default")
public class QuestionParserOriginal implements QuestionParser {
    public ParsedQuestion parse(Question question) {
        StringTokenizer stringTokenizer = new StringTokenizer(question.question);

        ArrayList<String> tokens = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }

        return new ParsedQuestion(tokens);
    }
}
