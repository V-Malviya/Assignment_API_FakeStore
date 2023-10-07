package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTMentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);
    Mentor findMentorById(long id);
}
