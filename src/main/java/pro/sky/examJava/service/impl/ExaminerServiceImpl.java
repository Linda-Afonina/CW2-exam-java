package pro.sky.examJava.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examJava.Question;
import pro.sky.examJava.service.ExaminerService;
import pro.sky.examJava.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    public final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> collectionOfQuestion = new HashSet<>();
        while (collectionOfQuestion.size() < amount) {
            collectionOfQuestion.add(questionService.getRandomQuestion());
        }
        return new HashSet<>(collectionOfQuestion);
    }
}
