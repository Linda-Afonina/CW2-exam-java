package pro.sky.examJava.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examJava.Question;
import pro.sky.examJava.exceptions.ThereAreNoParamsException;
import pro.sky.examJava.exceptions.QuestionNotFoundException;
import pro.sky.examJava.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    List<Question> javaQuestions = new ArrayList<>(List.of(
            new Question("Когда был основан язык Java?",
                    "в 1995 году."),
            new Question(" Что такое переменная?",
                    "это контейнер данных, в котором хранятся значения данных во время выполнения программы."),
            new Question("Какие бывают типы данных?",
                    "примитивный и ссылочный типы."),
            new Question("Что такое цикл?",
                    "это конструкция кода, которая повторяет одно и то же действие несколько раз."),
            new Question("Что такое метод?", "это блок кода, который выполняет определенную функцию и " +
                    "позволяет использовать себя в нескольких местах без необходимости снова и снова писать один и тот же код.")
    ));

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new ThereAreNoParamsException("Введите данные!");
        }
        Question addedQuestion = new Question(question, answer);
        javaQuestions.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        if (question == null || answer == null) {
            throw new ThereAreNoParamsException("Введите данные!");
        }
        Question removedQuestion = new Question(question, answer);
        if (!javaQuestions.contains(removedQuestion)) {
            throw new QuestionNotFoundException("Нет такого вопроса.");
        }
        javaQuestions.remove(removedQuestion);
        return removedQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(javaQuestions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(javaQuestions);
        Random random = new Random();
        Question randomQuestion = javaQuestions.get(0);
        int count = 0;
        for (Question element : javaQuestions) {
            if (count == random.nextInt(list.size())) {
                randomQuestion = element;
                break;
            }
            count++;
        }
        return randomQuestion;
    }
}
