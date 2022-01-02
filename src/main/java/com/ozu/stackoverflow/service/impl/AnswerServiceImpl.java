package com.ozu.stackoverflow.service.impl;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.dao.repository.AnswerRepository;
import com.ozu.stackoverflow.dao.repository.CommentRepository;
import com.ozu.stackoverflow.dao.repository.QuestionRepository;
import com.ozu.stackoverflow.model.AnswerDto;
import com.ozu.stackoverflow.model.CommentDto;
import com.ozu.stackoverflow.service.AnswerService;
import com.ozu.stackoverflow.util.AnswerMapper;
import com.ozu.stackoverflow.util.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

	private final AnswerRepository answerRepository;
	private final CommentRepository commentRepository;
	private final QuestionRepository questionRepository;


	@Override
	public List<AnswerDto> getAllAnswers() {

		return AnswerMapper.MAPPER.toAnswerDtoList(answerRepository.findAll());
	}

	@Override
	public AnswerDto getAnswer(int id)
	{
		return AnswerMapper.MAPPER.toAnswerDto(answerRepository.getById(id));

	}

	@Override
	public AnswerDto postAnswer(AnswerDto answerDto) {
		Answer answer = AnswerMapper.MAPPER.toAnswer(answerDto);
		Optional<Question> question = questionRepository.findById(answerDto.getQuestionId());
		if(question.isPresent()){
			answer.setQuestion(question.get());
			answer = answerRepository.save(answer);
			answerDto.setId(answer.getId());
			return answerDto;
		}
		return null;
	}

	@Override
	public Boolean updateAnswer(Integer id, AnswerDto answerDto) {
		Optional<Answer> answer = answerRepository.findById(id);
		if(answer.isPresent()){
			answer.get().setText(answerDto.getText());
			answerRepository.save(answer.get());
			return true;
		}
		return false;
	}

	@Override
	public AnswerDto upvote(Integer id) {
		Optional<Answer> answer = answerRepository.findById(id);
		if(answer.isPresent()){
			answer.get().upvote();
			Answer answer1 = answerRepository.save(answer.get());
			return AnswerMapper.MAPPER.toAnswerDto(answer1);
		}
		return null;
	}

}
