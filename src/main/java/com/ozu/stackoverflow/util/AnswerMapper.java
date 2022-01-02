package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.model.AnswerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerMapper MAPPER = Mappers.getMapper(AnswerMapper.class);


    @Mapping(target = "people.name", source = "person")
    Answer toAnswer(AnswerDto answerDto);

    @Mapping(target = "person", source = "people.name")
    AnswerDto toAnswerDto(Answer answer);


    List<Answer> toAnswerList(List<AnswerDto> answerDtos);

    List<AnswerDto> toAnswerDtoList(List<Answer> answers);
}
