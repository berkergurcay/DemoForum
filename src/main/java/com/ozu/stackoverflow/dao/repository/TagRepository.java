package com.ozu.stackoverflow.dao.repository;


import com.ozu.stackoverflow.dao.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
