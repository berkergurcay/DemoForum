package com.ozu.stackoverflow.service.impl;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.dao.repository.AnswerRepository;
import com.ozu.stackoverflow.dao.repository.CommentRepository;
import com.ozu.stackoverflow.dao.repository.QuestionRepository;
import com.ozu.stackoverflow.dao.repository.TagRepository;
import com.ozu.stackoverflow.model.CommentDto;
import com.ozu.stackoverflow.service.CommentService;
import com.ozu.stackoverflow.util.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final QuestionRepository questionRepository;
    private final CommentRepository commentRepository;
    private final AnswerRepository answerRepository;



    @Override
    public List<CommentDto> getComments(int id) {
        return CommentMapper.MAPPER.toCommentDtoList(commentRepository.findCommentByQuestionId(id));

    }

    @Override
    public CommentDto postComment(Integer id, CommentDto commentDto) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            Comment comment = CommentMapper.MAPPER.toComment(commentDto);
            question.get().addComment(comment);
            comment.setQuestion(question.get());
            comment = commentRepository.save(comment);
            commentDto.setId(comment.getId());
            commentDto.setQuestionId(id);
            return commentDto;
        }
        return null;

    }

    @Override
    public List<CommentDto> getCommentsAnswer(int id) {
        return CommentMapper.MAPPER.toCommentDtoList(commentRepository.findCommentByAnswerId(id));
    }

    @Override
    public CommentDto postCommentAnswer(Integer id, CommentDto commentDto) {
        Optional<Answer> answer = answerRepository.findById(id);
        if(answer.isPresent()){
            Comment comment = CommentMapper.MAPPER.toComment(commentDto);
            answer.get().addComment(comment);
            comment.setAnswer(answer.get());
            comment = commentRepository.save(comment);
            commentDto.setId(comment.getId());
            commentDto.setAnswerId(id);
            return commentDto;
        }
        return null;
    }

    @Override
    public Boolean updateComment(Integer id, CommentDto commentDto) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            comment.get().setText(commentDto.getText());
            commentRepository.save(comment.get());
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteComment(Integer id) {
         Optional<Comment> comment = commentRepository.findById(id);
         if(comment.isPresent()){
             commentRepository.delete(comment.get());
             return true;
         }
         return false;
    }

    @Override
    public CommentDto upvoteComment(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            comment.get().increaseVoteCount();
            Comment comment1 = commentRepository.save(comment.get());
            return CommentMapper.MAPPER.toCommentDto(comment1);
        }
        return null;
    }
}
