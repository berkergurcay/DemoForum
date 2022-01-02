package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.model.AnswerDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class,PeopleMapper.class,QuestionMapper.class})
public interface AnswerMapper {

    AnswerMapper MAPPER = Mappers.getMapper(AnswerMapper.class);

    @Named("AnswerDtoIgnorePeopleAndCommentChildAnswer")
    @IterableMapping(qualifiedByName = "")


    @Mappings({
            @Mapping(target = "people.answers")
    })
    AnswerDto toAnswerDto(Answer answer);

    List<AnswerDto> toAnswerDtos(List<Answer> answers);

    Answer toAnswer(AnswerDto answerDto);

    List<Answer> toAnswers(List<AnswerDto> answerDtos);

}
