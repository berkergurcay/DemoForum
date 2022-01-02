package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.model.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper{

    CommentMapper MAPPER = Mappers.getMapper(CommentMapper.class);


    @Mapping(target = "people.name",source = "person" )
    Comment toComment(CommentDto commentDto);

    @Mapping(target = "person" ,source = "people.name" )
    CommentDto toCommentDto(Comment comment);

    List<Comment> toCommentList(List<CommentDto> commentDtos);

    List<CommentDto> toCommentDtoList(List<Comment> comments);
}
