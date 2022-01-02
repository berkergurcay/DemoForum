package com.ozu.stackoverflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {
	private int id;
	private String text;
	private PeopleDto people;
	private QuestionDto question;
	private AnswerDto answer;
}
