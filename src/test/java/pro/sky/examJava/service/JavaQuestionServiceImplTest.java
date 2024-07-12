package pro.sky.examJava.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.examJava.Question;
import pro.sky.examJava.exceptions.QuestionNotFoundException;
import pro.sky.examJava.exceptions.ThereAreNoParamsException;
import pro.sky.examJava.service.impl.JavaQuestionServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceImplTest {

    JavaQuestionServiceImpl out;
    List<Question> javaQuestionsForTest;

    @BeforeEach
    public void setUp() {
        out = new JavaQuestionServiceImpl();
        javaQuestionsForTest = new ArrayList<>(List.of(
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
    }

    @Test
    public void shouldAddCorrectQuestion() {
        Question expected = new Question("Какие виды памяти существуют в Java?", "стек и куча.");
        Question actual = out.add(expected.getQuestion(), expected.getAnswer());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowThereAreNoParamsExceptionWhenParamsAreMissingDuringAdding() {
        Question expected = out.add("Какие виды памяти существуют в Java?", "стек и куча.");
        assertThrows(ThereAreNoParamsException.class,
                () -> out.add("Какие виды памяти существуют в Java?", null));
    }

    @Test
    public void shouldRemoveCorrectQuestion() {
        Question expected = new Question("Когда был основан язык Java?", "в 1995 году.");
        Question actual = out.remove(expected.getQuestion(), expected.getAnswer());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowThereAreNoParamsExceptionWhenParamsAreMissingDuringRemoving() {
        Question expected = out.remove("Когда был основан язык Java?", "в 1995 году.");
        assertThrows(ThereAreNoParamsException.class,
                () -> out.remove("Когда был основан язык Java?", null));
    }

    @Test
    public void shouldThrowQuestionNotFoundExceptionWhenQuestionIsNotFoundDuringRemoving() {
        Question expected = out.remove("Когда был основан язык Java?", "в 1995 году.");
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove("Какие виды памяти существуют в Java?", "стек и куча."));
    }

    @Test
    public void shouldGetAllQuestions() {
        Collection<Question> expected = javaQuestionsForTest;
        Collection<Question> actual = out.getAll();

        assertEquals(expected, actual);
    }
}
