package com.ozu.stackoverflow.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "T_ANSWER")
@Table(name = "T_ANSWER")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String answeredBy;
	private String text;
	private int voteCount;

	@ManyToOne
	@JoinColumn(name = "QUESTION_ID")
	private Question question;

	@OneToMany(mappedBy = "answer")
	private List<Comment> comments = new ArrayList<>();


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

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
