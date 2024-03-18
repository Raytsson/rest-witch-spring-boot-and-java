package br.com.raytsson.restwitchspringbootandjava.repositories;

import br.com.raytsson.restwitchspringbootandjava.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
