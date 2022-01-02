package com.ozu.stackoverflow.dao.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "T_COMMENT")
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String text;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PEOPLE_ID")
	private People people;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID")
	Question question;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ANSWER_ID")
	Answer answer;

	public Comment(String text){
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
