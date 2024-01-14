package com.grocery.api.repository;

import com.grocery.api.dom.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {

    @Override
    <S extends PersonInfo> S save(S entity);

    Optional<PersonInfo> findByPersonId(Long personId);

    void deleteByPersonId(Long personId);


}
