package com.ozu.stackoverflow.dao.repository;

import com.ozu.stackoverflow.dao.entity.Question;
import com.ozu.stackoverflow.dao.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
