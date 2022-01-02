package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.model.QuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionMapper MAPPER = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "people.name", source = "person")
    Question toQuestion(QuestionDto questionDto);

    @Mapping(target = "person", source = "people.name")
    QuestionDto toQuestionDto(Question question);


    List<Question> toQuestionList(List<QuestionDto> questionDto);


    List<QuestionDto> toQuestionDtoList(List<Question> questions);
}
