package com.ozu.stackoverflow.model;

import lombok.Data;

import java.util.List;

@Data
public class TagDto {
	String tag;
	List<QuestionDto> questions;
}
