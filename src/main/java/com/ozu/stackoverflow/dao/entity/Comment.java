package com.ozu.stackoverflow.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_COMMENT")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String answeredBy;
	private String text;

	@ManyToOne
	@JoinColumn(name = "QUESTION_ID")
	Question question;

	@ManyToOne
	@JoinColumn(name = "ANSWER_ID")
	Answer answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnsweredBy() {
		return answeredBy;
	}

	public void setAnsweredBy(String user) {
		this.answeredBy = user;
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
