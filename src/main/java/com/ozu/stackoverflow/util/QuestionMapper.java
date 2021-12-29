package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.model.AnswerDto;
import com.ozu.stackoverflow.model.CommentDto;
import com.ozu.stackoverflow.model.QuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

	QuestionDto toQuestionDto(Question question);

	List<QuestionDto> toQuestionDtos(List<Question> questions);

	Question toQuestion(QuestionDto question);

	List<Question> toQuestions(List<QuestionDto> questionDtos);

}
