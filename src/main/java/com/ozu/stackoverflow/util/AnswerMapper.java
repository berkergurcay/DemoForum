package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.model.AnswerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerDto toAnswerDto(Answer answer);

    List<AnswerDto> toAnswerDtos(List<Answer> answers);

    Answer toAnswer(AnswerDto answerDto);

    List<Answer> toAnswers(List<AnswerDto> answerDtos);


}
