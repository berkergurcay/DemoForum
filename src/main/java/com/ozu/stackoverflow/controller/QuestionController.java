package com.ozu.stackoverflow.controller;

import com.ozu.stackoverflow.model.QuestionDto;
import com.ozu.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
