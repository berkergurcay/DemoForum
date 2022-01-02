package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.model.QuestionDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class,PeopleMapper.class, TagMapper.class})
public interface QuestionMapper {

	QuestionDto toQuestionDto(Question question);

	List<QuestionDto> toQuestionDtos(List<Question> questions);

	Question toQuestion(QuestionDto question);

	List<Question> toQuestions(List<QuestionDto> questionDtos);


}
