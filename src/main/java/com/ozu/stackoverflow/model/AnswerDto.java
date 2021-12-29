package com.ozu.stackoverflow.model;

import lombok.Data;

import java.util.List;

@Data
public class AnswerDto {
	private int id;
	private String answeredBy;
	private String text;
	private int voteCount;
	private List<CommentDto> comments;
}
