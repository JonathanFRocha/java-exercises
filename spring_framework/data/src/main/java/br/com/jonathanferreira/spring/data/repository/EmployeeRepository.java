package br.com.jonathanferreira.spring.data.repository;

import br.com.jonathanferreira.spring.data.orm.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
