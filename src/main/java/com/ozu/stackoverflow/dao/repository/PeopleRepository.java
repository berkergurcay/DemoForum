package com.ozu.stackoverflow.dao.repository;

import com.ozu.stackoverflow.dao.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People,Integer> {
}
