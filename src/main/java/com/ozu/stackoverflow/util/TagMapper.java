package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Tag;
import com.ozu.stackoverflow.model.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagMapper MAPPER = Mappers.getMapper(TagMapper.class);

    Tag toTag(TagDto tagDto);

    TagDto toTagDto(Tag tag);

    List<Tag> toTagList(List<TagDto> tagDtoList);

    List<TagDto> toTagDtoList(List<Tag> tagList);
}
