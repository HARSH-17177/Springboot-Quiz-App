package com.harsh.quizapp.service; 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harsh.quizapp.dao.QuestionDao;
import com.harsh.quizapp.model.Question;

@Service  //similarly we can use component here
public class QuestionService {
@Autowired
QuestionDao questionDao;

    // public List<Question> getAllQuestions() {
    //  return   questionDao.findAll();
    // }

    public ResponseEntity<List<Question>> getAllQuestions() {
        try
        {

            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK) ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST) ;
    }

    // public List<Question> getQuestionsByCategory(String category) {
    //     return questionDao.findByCategory(category);
    // }


    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try
        {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


//     public String addQuestion(Question question) {
// questionDao.save(question);
// return "Success";
//     }



    public ResponseEntity<String> addQuestion(Question question) {
questionDao.save(question);
return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    // public String updateQuestion(Question question) {
    //     questionDao.save(question);
    //     return "Success";
    // }

    public String deleteQuestion(Integer id) {
       questionDao.deleteById(id);
		return "Deleted " + id + "th question";
    }


    
}
