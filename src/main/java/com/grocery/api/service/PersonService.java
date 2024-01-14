package com.grocery.api.service;

import com.grocery.api.dom.Person;
import com.grocery.api.model.JPerson;
import com.grocery.api.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonInfoService personInfoService;
    private final DomainService domainService;

//    private JPerson parseEntity(Person person) {
//        return JPerson.builder()
//                .nickname(person.getNickname())
//                .phoneNumber(person.getPhoneNumber())
//                .address(person.getAddress())
//                .domains(domainService.parseDomains(person.getDomains()))
//                .additionalInfo(person.getInfo().getAdditionalInfo())
//                .build();
//    }

    public Person createPerson(Person person, String domain) {
        domainService.getDomainByDomain(domain);

        return personRepository.save(person);
    }

    public Person getById(long id) {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Person with id" + id + " not found"));
    }

    public List<Person> getAllPersons() {
        return personRepository
                .findAll();
    }


    public JPerson update(long id, ReqPerson reqPerson) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        Person newPerson = new Person();
        if (optionalPerson.isPresent()) {
            if (reqPerson.nickname != null) {
                newPerson.setNickname(reqPerson.getNickname());
            }
            if (reqPerson.address != null) {
                newPerson.setAddress(reqPerson.getAddress());
            }
            if (reqPerson.phoneNumber != null) {
                newPerson.setPhoneNumber(reqPerson.getPhoneNumber());
            }
            if (reqPerson.additionalInfo != null) {
                personInfoService.updateInfoByPersonId(id, reqPerson.additionalInfo);
            }
            Person oldPerson = optionalPerson.get();
            oldPerson.setNickname(newPerson.getNickname());
            oldPerson.setAddress(newPerson.getAddress());
            oldPerson.setPhoneNumber(newPerson.getPhoneNumber());
            personRepository.save(oldPerson);
        }
        return null;
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class ReqPerson {
        private String nickname;
        private String phoneNumber;
        private String address;
        private String additionalInfo;
    }
}
