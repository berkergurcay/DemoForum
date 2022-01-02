package com.ozu.stackoverflow.service;

import com.ozu.stackoverflow.model.CommentDto;

import java.util.List;

public interface CommentService {


    CommentDto postComment(Integer id, CommentDto commentDto);

    List<CommentDto> getComments(int id);

    CommentDto postCommentAnswer(Integer id, CommentDto commentDto);

    List<CommentDto> getCommentsAnswer(int id);

    Boolean updateComment(Integer id, CommentDto commentDto);

    Boolean deleteComment(Integer id);

    CommentDto upvoteComment(Integer id);
}
