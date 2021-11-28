package br.com.jonathanferreira.spring.data.repository;

import br.com.jonathanferreira.spring.data.orm.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {
}
