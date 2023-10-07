package com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCTARepository extends JpaRepository<TA,Long> {
    TA save(TA ta);
    TA findTAById(long id);
}
