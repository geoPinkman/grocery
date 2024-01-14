package com.grocery.api.service;

import com.grocery.api.dom.Domain;
import com.grocery.api.dom.Person;
import com.grocery.api.repository.DomainRepository;
import com.grocery.api.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DomainService {

    private final DomainRepository domainRepository;
    private final PersonRepository personRepository;

    public Domain createDomain(Domain domain) {
        return domainRepository.save(domain);
    }

    public List<Domain> getAllDomains() {
       return domainRepository.findAll();
    }

    public List<Domain> getDomainByPersonId(long personId) {
        Person person = personRepository.findById(personId).get();
        return domainRepository.getDomainsByPersons(person);
    }

    public void deleteDomainById(long id) {
        domainRepository.deleteById(id);
    }

    public Domain addDomainToPersonByPersonId(long personId, String newDomain) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            Domain domain = new Domain();
            domain.setDomain(newDomain);
            domain.getPersons().add(person);
            return domainRepository.save(domain);
        } else {
            throw new RuntimeException("");
        }
    }

    public Domain getDomainByDomain(String domain) {
        return domainRepository.getDomainByDomain(domain)
                .orElseThrow(() -> new RuntimeException(""));
    }

    public Domain deleteDomainForPersonByPersonId(long personId, String oldDomain) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            return domainRepository.deleteDomainByPersonsAndDomain(person, oldDomain);
        } else {
            throw new RuntimeException("");
        }

    }

}
