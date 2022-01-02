package com.ozu.stackoverflow.controller;

import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.model.CommentDto;
import com.ozu.stackoverflow.model.QuestionDto;
import com.ozu.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@GetMapping(value = "/questions")
	public ResponseEntity<List<QuestionDto>> getAllQuestions() {
		return ResponseEntity.ok(questionService.getAllQuestions());
	}

	@GetMapping(value = "/questions/{tag}")
	public ResponseEntity<List<QuestionDto>> getAllQuestionsWithTag(@PathVariable(value = "tag") String tag) {
		return ResponseEntity.ok(questionService.getQuestionsWithTag(tag));
	}

	@GetMapping(value = "/question/{id}")
	public ResponseEntity<QuestionDto> getQuestion(@PathVariable int id) {
		return ResponseEntity.ok(questionService.getQuestion(id));
	}


	@PostMapping(value = "/question")
	public ResponseEntity<QuestionDto> askQuestion(@RequestBody QuestionDto questionDto){
		return ResponseEntity.ok(questionService.askQuestion(questionDto));
	}

	@PostMapping(value = "/question/{id}/vote")
	public ResponseEntity<QuestionDto> upvoteQuestion(@PathVariable Integer id){
		return ResponseEntity.ok(questionService.upvoteQuestion(id));
	}



}
