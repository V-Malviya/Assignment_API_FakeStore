package com.restapi.fakestoreapiproxy.inheritancePractice.Single_table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STTARepository extends JpaRepository<TA,Long> {
    TA save(TA ta);
    TA findTAById(long id);
}
