package com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSMentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);
    Mentor findMentorById(long id);
}
