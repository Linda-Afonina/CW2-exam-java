package pro.sky.examJava.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examJava.Question;
import pro.sky.examJava.service.impl.ExaminerServiceImpl;
import pro.sky.examJava.service.impl.JavaQuestionServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    List<Question> javaQuestionsForTest = new ArrayList<>(List.of(
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

    @Mock
    JavaQuestionServiceImpl javaQuestionServiceImpl;

    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;

    @Test
    public void shouldGetCorrectAmountOfQuestions() {
        Question expectedQuestion1 = new Question("Вопрос1", "ответ1");
        Question expectedQuestion2 = new Question("Вопрос2", "ответ2");
        when(javaQuestionServiceImpl.getRandomQuestion())
                .thenReturn(expectedQuestion1)
                .thenReturn(expectedQuestion2);
        Collection<Question> questions = examinerServiceImpl.getQuestions(2);
        assertEquals(2, questions.size());
    }
}
