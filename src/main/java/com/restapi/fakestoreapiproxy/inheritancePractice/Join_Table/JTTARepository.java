package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTTARepository extends JpaRepository<TA,Long> {
    TA save(TA ta);
    TA findTAById(long id);
}
