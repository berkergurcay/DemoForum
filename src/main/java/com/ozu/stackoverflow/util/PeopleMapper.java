package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.People;
import com.ozu.stackoverflow.model.PeopleDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class,QuestionMapper.class})
public interface PeopleMapper {

    People toPeople(PeopleDto peopleDto);

    List<People> toPeoples(List<PeopleDto> peopleDtos);

    PeopleDto toPeopleDto(People people);

    List<PeopleDto> toPeopleDtos(List<People> peoples);


}
