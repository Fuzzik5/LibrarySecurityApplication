package ru.khabib.librarySecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.khabib.librarySecurity.models.Person;
import ru.khabib.librarySecurity.repositories.PeopleRepositories;
import ru.khabib.librarySecurity.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepositories peopleRepositories;

    @Autowired
    public PersonDetailsService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepositories.findPersonByUsername(s);
        if(person.isEmpty()) throw new UsernameNotFoundException("User not found!");
        return new PersonDetails(person.get());
    }
}
