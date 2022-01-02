package com.ozu.stackoverflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TagDto {
	private int id;
	String name;
	List<QuestionDto> questions;
}
