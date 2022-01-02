package com.ozu.stackoverflow;

import com.ozu.stackoverflow.dao.entity.*;
import com.ozu.stackoverflow.dao.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class StackoverflowApplicationTests {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	TagRepository tagRepository;

	@Autowired
	PeopleRepository peopleRepository;

	@Test
	void setQuestions(){
		Question question = new Question();
		question.setTitle("Spring boot pom.xml");
		question.setText("Cannot configure pom for my spring boot project");


		Tag tag = new Tag();
		tag.setName("spring");
		tag.setQuestions(Arrays.asList(question));

		question.setTags(Arrays.asList(tag));

		questionRepository.save(question);
		// tagRepository.save(tag);
	}

	@Test
	void initializeTables(){
		People people1 = new People("berkergurcay");
		People people2 = new People("gurcayberker");
		People people3 = new People("anonim");

		Tag tag1 = new Tag("spring");

		Tag tag2 = new Tag("boot");


		Question question = new Question("Spring boot update");
		question.setText("Cant update spring boot version");
		question.setPeople(people1);
		question.setTags(Arrays.asList(tag1,tag2));

		people1.setQuestions(Arrays.asList(question));

		tag1.setQuestions(Arrays.asList(question));
		tag2.setQuestions(Arrays.asList(question));

		Answer answer1 = new Answer("Refer to documentation");
		answer1.setPeople(people2);
		answer1.setVoteCount(55);
		answer1.setQuestion(question);

		Answer answer2 = new Answer("Duplicate question marked");
		answer2.setPeople(people3);
		answer2.setQuestion(question);

		people2.setAnswers(Arrays.asList(answer1));
		people3.setAnswers(Arrays.asList(answer2));

		question.setAnswers(Arrays.asList(answer1,answer2));

		peopleRepository.save(people1);
		peopleRepository.save(people2);
		peopleRepository.save(people3);


	}

	@Test
	void contextLoads() {

		Question question = new Question();
		question.setTitle("Spring boot pom.xml");
		question.setText("Cannot configure pom for my spring boot project");


		People people = new People();
		people.setName("berker");
		people.setQuestions(Arrays.asList(question));

		question.setPeople(people);

		Tag tag = new Tag();
		tag.setName("spring");

		question.setTags(Arrays.asList(tag));
		tag.setQuestions(Arrays.asList(question));

		Answer answer = new Answer();
		answer.setText("No code can't help");
		answer.setQuestion(question);


		Comment comment1 = new Comment();
		Comment comment2 = new Comment();


		comment1.setText("Could you repeat that");
		comment1.setAnswer(answer);
		comment1.setPeople(people);

		question.setAnswers(Arrays.asList(answer));
		question.setComments(Arrays.asList(comment2));

		comment2.setText("No I can't");
		comment2.setQuestion(question);
		peopleRepository.save(people);
		//questionRepository.save(question);




	}

}
