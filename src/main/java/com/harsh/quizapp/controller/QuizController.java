package com.harsh.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.quizapp.model.QuestionWrapper;
import com.harsh.quizapp.model.Response;
import com.harsh.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

@Autowired
QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
return  quizService.createQuiz(category,numQ,title);
    }


@GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
return quizService.getQuizQuestion(id);
    }

@PostMapping("submit/{id}")
public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response)    
{
return quizService.calculateResult(id,response);
}
}


// http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz                 for creating quiz

// http://localhost:8080/quiz/submit/1             for submitting answers of question we got form above api link
// [
// {
//     "id":2,
//     "response":"5"
// },
// {
//     "id":4,
//     "response":"throw"
// },
// {
//     "id":5,
//     "response":"final int x = 5;"
// },
// {
//     "id":13,
//     "response":"Math.PI"
// },
// {
//     "id":9,
//     "response":"-"
// }
// ]