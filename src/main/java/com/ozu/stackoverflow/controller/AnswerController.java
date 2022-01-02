package com.ozu.stackoverflow.controller;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.model.AnswerDto;
import com.ozu.stackoverflow.model.CommentDto;
import com.ozu.stackoverflow.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping(value = "/answer/{id}")
    public ResponseEntity<AnswerDto> getAnswer(@PathVariable int id){
        return ResponseEntity.ok(answerService.getAnswer(id));
    }

    @PostMapping(value = "/answer")
    public ResponseEntity<AnswerDto> postAnswer(@RequestBody AnswerDto answerDto){
        return ResponseEntity.ok(answerService.postAnswer(answerDto));
    }

    @PutMapping(value = "/answer/{id}/update")
    public ResponseEntity<Boolean> updateAnswer(@PathVariable Integer id, @RequestBody AnswerDto answerDto){
        return ResponseEntity.ok(answerService.updateAnswer(id,answerDto));
    }

    @PostMapping(value = "/answer/{id}/vote")
    public ResponseEntity<AnswerDto> upvoteAnswer(@PathVariable Integer id){
        return ResponseEntity.ok(answerService.upvote(id));
    }

}
