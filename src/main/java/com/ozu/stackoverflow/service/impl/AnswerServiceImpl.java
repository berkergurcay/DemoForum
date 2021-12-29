package com.ozu.stackoverflow.service.impl;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.dao.repository.AnswerRepository;
import com.ozu.stackoverflow.model.AnswerDto;
import com.ozu.stackoverflow.service.AnswerService;
import com.ozu.stackoverflow.util.AnswerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {



	private final AnswerRepository answerRepository;

	private final AnswerMapper answerMapper;

	@Override
	public List<AnswerDto> getAllAnswers() {
		return answerMapper.toAnswerDtos(answerRepository.findAll());


	}

	@Override
	public AnswerDto getAnswer(int id) {
		return answerMapper.toAnswerDto(answerRepository.getById(id));
	}
}
