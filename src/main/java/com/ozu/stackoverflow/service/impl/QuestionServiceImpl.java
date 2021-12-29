package com.ozu.stackoverflow.service.impl;

import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.dao.repository.QuestionRepository;
import com.ozu.stackoverflow.dao.repository.TagRepository;
import com.ozu.stackoverflow.model.QuestionDto;
import com.ozu.stackoverflow.service.QuestionService;
import com.ozu.stackoverflow.util.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {


	private final QuestionRepository questionRepository;

	private final TagRepository tagRepository;

	private final QuestionMapper questionMapper;

	@Override
	public List<QuestionDto> getAllQuestions() {
		return questionMapper.toQuestionDtos(questionRepository.findAll());
	}



	@Override
	public QuestionDto getQuestion(int id) {
		return questionMapper.toQuestionDto(questionRepository.getById(id));
	}
}
