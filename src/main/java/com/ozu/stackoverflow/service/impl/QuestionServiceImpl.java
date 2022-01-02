package com.ozu.stackoverflow.service.impl;

import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.dao.entity.Tag;
import com.ozu.stackoverflow.dao.repository.QuestionRepository;
import com.ozu.stackoverflow.dao.repository.TagRepository;
import com.ozu.stackoverflow.model.QuestionDto;
import com.ozu.stackoverflow.service.QuestionService;
import com.ozu.stackoverflow.util.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {


	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;

	private final QuestionMapper questionMapper;

	@Override
	public List<QuestionDto> getAllQuestions() {
		List<Question> questions = questionRepository.findAll();
		return questionMapper.toQuestionDtos(questions);
	}


	@Override
	public QuestionDto getQuestion(int id) {
		Optional<Question> question = questionRepository.findById(id);
		return questionMapper.toQuestionDto(question.get());
	}

	@Override
	public List<QuestionDto> getQuestionsWithTag(String tag) {
		Tag tag1 = tagRepository.getTagByNameEquals(tag);
		return questionMapper.toQuestionDtos(tag1.getQuestions());

	}
}
