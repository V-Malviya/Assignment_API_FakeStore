package com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSInstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save(Instructor instructor);
    Instructor findInstructorById(long id);
}
