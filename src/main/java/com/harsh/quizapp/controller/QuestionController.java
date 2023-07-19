package com.harsh.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.quizapp.model.Question;
import com.harsh.quizapp.service.QuestionService;

@RestController //as here we want to accept the request
@RequestMapping("question")
public class QuestionController {

    @Autowired
QuestionService questionService;

//     @GetMapping("allQuestions")
//     public  List<Question> getAllQuestions()
//     {
// return questionService.getAllQuestions();
//     }


    @GetMapping("allQuestions")
    public  ResponseEntity<List<Question>> getAllQuestions()//here we along with data also showing the status code using ResponseEntity<>() here we dont have to again return REsponse Entity as we already returning in service class
    {
return questionService.getAllQuestions();
    }

//     @GetMapping("category/{category}") //here {category} is the variable which would be stored in Pathvariable 
//     public List<Question> getQuestionsByCategory(@PathVariable String category) //here from url we are getting the request which may be category/java or category/python etc therefore for handling the requestion which will come as variable {category} We define Path variable where we store the requested value
//     {
// return questionService.getQuestionsByCategory(category);
//     }


    @GetMapping("category/{category}") //here {category} is the variable which would be stored in Pathvariable 
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) //here from url we are getting the request which may be category/java or category/python etc therefore for handling the requestion which will come as variable {category} We define Path variable where we store the requested value
    {
return questionService.getQuestionsByCategory(category);
    }






    // @PostMapping("add")
    // public String addQuestion(@RequestBody Question question)
    // {
    //    return questionService.addQuestion(question);
        
    // }



    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
       return questionService.addQuestion(question);
        
    }

    // @PutMapping("update/{id}")
    // public String updateQuestion(@RequestBody Question question)
    // {
    //     return questionService.updateQuestion(question);
    // }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id)
    {
return questionService.deleteQuestion(id);
    }


}



// http://localhost:8080/question/add         to add data
    // {
    //     "questionTitle": "how to use Pi value in java?",
    //     "option1": "3.14",
    //     "option2": "Math.PI",
    //     "option3": "π",
    //     "option4": "PI",
    //     "rightAnswer": "Math.PI",
    //     "category": "Java",
    //     "difficultylevel": "Easy"
    // }