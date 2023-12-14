package com.grocery.api.repository;

import com.grocery.api.dom.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    <S extends Person> S save(S entity);

    @Override
    List<Person> findAll();

    @Override
    Optional<Person> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
