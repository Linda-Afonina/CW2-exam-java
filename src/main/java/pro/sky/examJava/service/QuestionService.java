package pro.sky.examJava.service;

import pro.sky.examJava.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public interface QuestionService {

    Set<Question> javaQuestions = new HashSet<>();

    Question add(String question, String answer);


    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();


}
