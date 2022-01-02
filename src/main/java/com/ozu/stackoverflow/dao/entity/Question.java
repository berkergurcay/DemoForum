package com.ozu.stackoverflow.dao.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_QUESTION")
@NoArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String title;
	private String text;

	private Date askedDate = new Date();

	private Integer answerCount;
	private Integer voteCount = 1;
	private Integer viewCount = 1;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PEOPLE_ID")
	private People people;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<>();

	@ManyToMany(mappedBy = "questions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Tag> tags = new ArrayList<>();

	public Question(String title){
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAskedDate() {
		return askedDate;
	}

	public void setAskedDate(Date askedDate) {
		this.askedDate = askedDate;
	}

	public Integer getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void addComment(Comment comment){
		this.comments.add(comment);
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
		this.answerCount = answers.size();
	}

	public void upvote(){

		if(this.voteCount!= null)
			this.voteCount++;
		else
			this.voteCount = 1;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
