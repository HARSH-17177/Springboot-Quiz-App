package com.harsh.quizapp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.harsh.quizapp.dao.QuestionDao;
import com.harsh.quizapp.dao.QuizDao;
import com.harsh.quizapp.model.Question;
import com.harsh.quizapp.model.QuestionWrapper;
import com.harsh.quizapp.model.Quiz;
import com.harsh.quizapp.model.Response;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
     List<Question> questions =questionDao.findRandomQuestionByCategory(category,numQ); //for generating random questions
      Quiz quiz =new Quiz();
      quiz.setTitle(title);
      quiz.setQuestions(questions);
      quizDao.save(quiz);
      return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz= quizDao.findById(id); //here Optional is used bcoz if the id we are searching is not present so it will not throw an error
        List<Question> questionFromDB = quiz.get().getQuestions(); //this is the question that we will receive from the database along with answers
List<QuestionWrapper> questionForUser =new ArrayList<>();// this would be used to store the questions without answers with the help of below loop
for(Question q: questionFromDB)
{
  QuestionWrapper qw =new QuestionWrapper(q.getId(),q.getQuestionTitle() , q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
  questionForUser.add(qw);
}
return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
      Quiz quiz =quizDao.findById(id).get(); //if you use .get() we dont need Optional<Quiz>
      List<Question> questions =quiz.getQuestions();
      int right=0,i =0;
for(Response response: responses)
{
  if(response.getResponse().equals(questions.get(i).getRightAnswer()))
  {
    right ++;
  }
  i++;
}
return new ResponseEntity<Integer>(right,HttpStatus.OK);
    }

   
    
}
