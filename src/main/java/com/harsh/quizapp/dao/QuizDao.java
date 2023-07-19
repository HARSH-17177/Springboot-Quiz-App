package com.harsh.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
