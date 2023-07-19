package com.harsh.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//all handling of data from database would be done by jpa JpaRepository<class name,primarykey>
import org.springframework.data.jpa.repository.Query;

import com.harsh.quizapp.model.Question;
public interface QuestionDao extends JpaRepository<Question,Integer>{
    
   List<Question> findByCategory(String category);

   @Query(value = "select * from question q where q.category=:category order by RANDOM() limit :numQ",nativeQuery = true)
List<Question> findRandomQuestionByCategory(String category, int numQ);

}
