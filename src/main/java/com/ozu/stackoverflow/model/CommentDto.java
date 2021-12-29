package com.ozu.stackoverflow.model;

import lombok.Data;

@Data
public class CommentDto {
	private int id;
	private String answeredBy;
	private String text;
	private QuestionDto question;
	private AnswerDto answer;
}
