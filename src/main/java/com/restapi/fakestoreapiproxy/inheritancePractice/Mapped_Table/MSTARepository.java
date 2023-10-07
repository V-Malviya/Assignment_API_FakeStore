package com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSTARepository extends JpaRepository<TA,Long> {
    TA save(TA ta);
    TA findTAById(long id);
}
