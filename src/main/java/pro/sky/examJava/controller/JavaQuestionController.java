package pro.sky.examJava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examJava.Question;
import pro.sky.examJava.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("java")
public class JavaQuestionController {

    public final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping("random")
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }
}
