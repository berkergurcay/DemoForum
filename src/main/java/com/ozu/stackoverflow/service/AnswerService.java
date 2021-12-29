package com.ozu.stackoverflow.service;

import com.ozu.stackoverflow.model.AnswerDto;

import java.util.List;

public interface AnswerService {

	List<AnswerDto> getAllAnswers();

	AnswerDto getAnswer(int id);
}
