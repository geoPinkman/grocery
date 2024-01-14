package com.grocery.api.service;

import com.grocery.api.dom.PersonInfo;
import com.grocery.api.model.JPersonInfo;
import com.grocery.api.repository.PersonInfoRepository;
import com.grocery.api.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PersonInfoService {

    private final PersonInfoRepository personInfoRepository;
    private final PersonRepository personRepository;

    public JPersonInfo parsePersonInfo(PersonInfo personInfo) {
        return JPersonInfo.builder()
                .additionalInfo(personInfo.getAdditionalInfo())
                .build();
    }

    public PersonInfo create(PersonInfo info) {
        return personInfoRepository.save(info);
    }

    public PersonInfo getInfoByPersonId(long personId) {
        return personInfoRepository.findByPersonId(personId)
                .orElseThrow(() -> new RuntimeException("person info by person " + personId + "is not available"));
    }

    public PersonInfo updateInfoByPersonId(Long personId, String info) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPerson(personRepository.findById(personId).get());
        personInfo.setAdditionalInfo(info);
        return personInfoRepository.save(personInfo);
    }

    public void deleteInfoById(long id) {
        personInfoRepository.deleteById(id);
    }

}
