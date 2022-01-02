package com.ozu.stackoverflow.util;

import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.model.CommentDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AnswerMapper.class, PeopleMapper.class, QuestionMapper.class})
public interface CommentMapper {
    Comment toComment(CommentDto commentDto);

    List<Comment> toComments(List<CommentDto> commentDtos);

    CommentDto toCommentDto(Comment comment);

    List<CommentDto> toCommentDtos(List<Comment> comment);

}
