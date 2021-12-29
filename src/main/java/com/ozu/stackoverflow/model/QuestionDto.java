package com.ozu.stackoverflow.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QuestionDto {
	private int id;
	private String title;
	private String text;
	private String askedBy;

	private int viewCount;
	private int voteCount;
	private int answerCount;

	private Date askedDate;

	private List<TagDto> tags;
	private List<CommentDto> comments;
	private List<AnswerDto> answers;

}
