package com.ozu.stackoverflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class QuestionDto {
	private int id;
	private String title;
	private String text;

	private Date askedDate;

	private int answerCount;
	private int voteCount;
	private int viewCount;


	private PeopleDto people;
	private List<CommentDto> comments;
	private List<AnswerDto> answers;
	private List<TagDto> tags;

}
