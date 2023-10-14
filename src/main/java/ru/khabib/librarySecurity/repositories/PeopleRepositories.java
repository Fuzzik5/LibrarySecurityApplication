package ru.khabib.librarySecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.khabib.librarySecurity.models.Person;

import java.util.Optional;

@Repository
public interface PeopleRepositories extends JpaRepository<Person, Integer> {
    Optional<Person> findPersonByUsername(String username);
}
