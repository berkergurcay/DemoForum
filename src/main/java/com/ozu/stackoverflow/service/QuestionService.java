package com.ozu.stackoverflow.service;

import com.ozu.stackoverflow.model.QuestionDto;

import java.util.List;

public interface QuestionService {

	List<QuestionDto> getAllQuestions();


	QuestionDto getQuestion(int id);

    List<QuestionDto> getQuestionsWithTag(String tag);
}
