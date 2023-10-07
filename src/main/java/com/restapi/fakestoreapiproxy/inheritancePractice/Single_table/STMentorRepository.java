package com.restapi.fakestoreapiproxy.inheritancePractice.Single_table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STMentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);
    Mentor findMentorById(long id);
}
