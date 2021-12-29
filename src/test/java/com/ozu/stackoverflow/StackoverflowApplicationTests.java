package com.ozu.stackoverflow;

import com.ozu.stackoverflow.dao.entity.Answer;
import com.ozu.stackoverflow.dao.entity.Comment;
import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.dao.entity.Tag;
import com.ozu.stackoverflow.dao.repository.AnswerRepository;
import com.ozu.stackoverflow.dao.repository.CommentRepository;
import com.ozu.stackoverflow.dao.repository.QuestionRepository;
import com.ozu.stackoverflow.dao.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.Query;
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



	@Test
	void contextLoads() {
		Question question = new Question();
		question.setTitle("Spring boot pom.xml");
		question.setText("Cannot configure pom for my spring boot project");
		question.setAskedBy("berkergurcay");

		Tag tag = new Tag();
		tag.setTag("spring");

		question.setTags(Arrays.asList(tag));
		Answer answer = new Answer();
		answer.setAnsweredBy("berker");
		answer.setText("No code can't help");
		answer.setQuestion(question);


		Comment comment1 = new Comment();
		Comment comment2 = new Comment();

		comment1.setAnsweredBy("ilhami");
		comment1.setText("Could you repeat that");
		comment1.setAnswer(answer);


		comment2.setText("No I can't");
		comment2.setQuestion(question);

		tagRepository.save(tag);
		questionRepository.save(question);
		answerRepository.save(answer);


		commentRepository.save(comment1);
		commentRepository.save(comment2);



	}

}
