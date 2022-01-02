package com.ozu.stackoverflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PeopleDto {
    private int id;
    private String name;
    private List<QuestionDto> questions;
    private List<CommentDto> comments;
    private List<AnswerDto> answers;
}
