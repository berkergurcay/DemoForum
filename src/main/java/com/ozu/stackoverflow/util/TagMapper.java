package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Tag;
import com.ozu.stackoverflow.model.TagDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDto toTagDto(Tag tag);

    List<TagDto> toTagDtos(List<Tag> tags);

    Tag toTag(TagDto tagDto);

    List<Tag> toTags(List<TagDto> tagDtos);
}
