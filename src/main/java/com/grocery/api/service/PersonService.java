package com.grocery.api.service;


import com.grocery.api.dom.Person;
import com.grocery.api.model.JPerson;
import com.grocery.api.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class PersonService {

    private final PersonRepository repository;

    private JPerson parseEntity(Person person) {
        return JPerson.builder()
                .nickname(person.getNickname())
                .phoneNumber(person.getPhoneNumber())
                .address(person.getAddress())
                .domains(person.getDomains())
                .additionalInfo(person.getInfo().getAdditionalInfo())
                .build();
    }

    public JPerson getById(long id) {
        Person person = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Person with id" + id + " not found"));
        return parseEntity(person);
    }

    public List<JPerson> getAllPersons() {
        return repository
                .findAll()
                .stream()
                .map(this::parseEntity)
                .collect(Collectors.toList());
    }

}
