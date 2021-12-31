package br.com.jonathanferreira.spring.forum.repository;


import br.com.jonathanferreira.spring.forum.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Page<Topic> findByCourseName(String course, Pageable page);
}
