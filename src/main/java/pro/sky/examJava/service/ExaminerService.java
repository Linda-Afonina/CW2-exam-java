package pro.sky.examJava.service;

import pro.sky.examJava.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
