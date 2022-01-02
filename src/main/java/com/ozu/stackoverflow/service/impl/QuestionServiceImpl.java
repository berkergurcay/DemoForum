package com.ozu.stackoverflow.service.impl;

import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.dao.entity.Tag;
import com.ozu.stackoverflow.dao.repository.CommentRepository;
import com.ozu.stackoverflow.dao.repository.QuestionRepository;
import com.ozu.stackoverflow.dao.repository.TagRepository;
import com.ozu.stackoverflow.model.CommentDto;
import com.ozu.stackoverflow.model.QuestionDto;
import com.ozu.stackoverflow.service.QuestionService;
import com.ozu.stackoverflow.util.CommentMapper;
import com.ozu.stackoverflow.util.QuestionMapper;
import com.ozu.stackoverflow.util.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {


	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	private final CommentRepository commentRepository;





	@Override
	public List<QuestionDto> getAllQuestions() {
		List<Question> questions = questionRepository.findAll();
		return QuestionMapper.MAPPER.toQuestionDtoList(questions);

	}


	@Override
	public QuestionDto getQuestion(int id) {
		Optional<Question> question = questionRepository.findById(id);
		Question question1;
		if(question.isPresent())
			question1 = question.get();
		else
			return null;

		return QuestionMapper.MAPPER.toQuestionDto(question1);

	}

	@Override
	public List<QuestionDto> getQuestionsWithTag(String tag) {
		List<Tag> tags = tagRepository.getTagByNameEquals(tag);
		List<QuestionDto> questionDtos = new ArrayList<>();
		for(Tag tag1:tags){

			questionDtos.addAll(QuestionMapper.MAPPER.toQuestionDtoList(tag1.getQuestions()));
		}
		return questionDtos;
	}

	@Override
	public QuestionDto askQuestion(QuestionDto questionDto) {
		Question question = questionRepository.save(QuestionMapper.MAPPER.toQuestion(questionDto));
		questionDto.setId(question.getId());
		return questionDto;
	}

	@Override
	public QuestionDto upvoteQuestion(Integer id) {
		Optional<Question> question = questionRepository.findById(id);
		if(question.isPresent()){
			question.get().upvote();
			questionRepository.save(question.get());
			return QuestionMapper.MAPPER.toQuestionDto(question.get());
		}
		return null;
	}

}
