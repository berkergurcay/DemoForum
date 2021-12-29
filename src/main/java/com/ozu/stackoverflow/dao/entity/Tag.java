package com.ozu.stackoverflow.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_TAG")
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String tag;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REL_TAG_QUESTION", joinColumns = @JoinColumn(name = "TAG_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID"))
	private List<Question> questions = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
