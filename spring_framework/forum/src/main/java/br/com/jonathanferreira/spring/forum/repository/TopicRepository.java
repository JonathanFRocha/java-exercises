package br.com.jonathanferreira.spring.forum.repository;


import br.com.jonathanferreira.spring.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    List<Topic> findByCourseName(String course);
}
