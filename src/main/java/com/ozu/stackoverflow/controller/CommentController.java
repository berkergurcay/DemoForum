package com.ozu.stackoverflow.controller;

import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.model.CommentDto;
import com.ozu.stackoverflow.service.AnswerService;
import com.ozu.stackoverflow.service.CommentService;
import com.ozu.stackoverflow.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @GetMapping(value = "/question/{id}/comments")
    public ResponseEntity<List<CommentDto>> getComment(@PathVariable int id){
        return ResponseEntity.ok(commentService.getComments(id));
    }

    @PostMapping(value = "/question/{id}/comment")
    public ResponseEntity<CommentDto> postCommentToQuestion(@PathVariable Integer id, @RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.postComment(id,commentDto));
    }

    @GetMapping(value = "/answer/{id}/comments")
    public ResponseEntity<List<CommentDto>> getCommentAnswer(@PathVariable int id){
        return ResponseEntity.ok(commentService.getCommentsAnswer(id));
    }

    @PostMapping(value = "/answer/{id}/comment")
    public ResponseEntity<CommentDto> postCommentToAnswer(@PathVariable Integer id, @RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.postCommentAnswer(id,commentDto));
    }

    @PutMapping(value = "/comment/{id}/update")
    public ResponseEntity<Boolean> updateCommentAnswer(@PathVariable Integer id,@RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.updateComment(id,commentDto));
    }

    @DeleteMapping(value = "/comment/{id}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Integer id){
        return ResponseEntity.ok(commentService.deleteComment(id));
    }

    @PostMapping(value = "/comment/{id}/vote")
    public ResponseEntity<CommentDto> upvoteComment(@PathVariable Integer id){
        return ResponseEntity.ok(commentService.upvoteComment(id));
    }
}
