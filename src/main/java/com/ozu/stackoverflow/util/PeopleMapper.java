package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.People;
import com.ozu.stackoverflow.model.PeopleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeopleMapper {
    PeopleMapper MAPPER = Mappers.getMapper(PeopleMapper.class);

    People toPeople(PeopleDto peopleDto);

    PeopleDto toPeopleDto(People people);

    List<People> toPeopleList(List<People> peopleList);

    List<PeopleDto> toPeopleDtoList(List<PeopleDto> peopleDtos);
}
