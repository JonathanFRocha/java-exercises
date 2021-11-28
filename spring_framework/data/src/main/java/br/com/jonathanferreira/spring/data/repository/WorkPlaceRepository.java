package br.com.jonathanferreira.spring.data.repository;

import br.com.jonathanferreira.spring.data.orm.WorkPlace;
import org.springframework.data.repository.CrudRepository;

public interface WorkPlaceRepository extends CrudRepository<WorkPlace, Integer> {
}
