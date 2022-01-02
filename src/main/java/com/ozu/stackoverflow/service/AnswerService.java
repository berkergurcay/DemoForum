package com.ozu.stackoverflow.service;

import com.ozu.stackoverflow.model.AnswerDto;
import com.ozu.stackoverflow.model.CommentDto;

import java.util.List;

public interface AnswerService {

	List<AnswerDto> getAllAnswers();

	AnswerDto getAnswer(int id);

    AnswerDto postAnswer(AnswerDto answerDto);

    Boolean updateAnswer(Integer id, AnswerDto answerDto);

    AnswerDto upvote(Integer id);
}
