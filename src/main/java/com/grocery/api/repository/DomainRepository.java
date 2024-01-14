package com.grocery.api.repository;

import com.grocery.api.dom.Domain;
import com.grocery.api.dom.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

    @Override
    <S extends Domain> S save(S entity);

    @Override
    List<Domain> findAll();

    @Override
    void deleteById(Long aLong);

    Optional<Domain> getDomainByDomain(String domain);

    List<Domain> getDomainsByPersons(Person person);

    Domain deleteDomainByPersonsAndDomain(Person person, String domain);

}
