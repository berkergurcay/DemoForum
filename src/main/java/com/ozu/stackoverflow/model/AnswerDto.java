package com.ozu.stackoverflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDto {
	private int id;
	private PeopleDto people;
	private String text;
	private int voteCount;
	private List<CommentDto> comments;
	private QuestionDto question;
}
