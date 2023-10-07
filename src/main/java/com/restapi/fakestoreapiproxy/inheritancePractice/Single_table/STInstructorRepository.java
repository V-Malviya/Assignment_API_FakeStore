package com.restapi.fakestoreapiproxy.inheritancePractice.Single_table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STInstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save(Instructor instructor);
    Instructor findInstructorById(long id);
}
