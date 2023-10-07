package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTInstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save(Instructor instructor);
    Instructor findInstructorById(long id);
}
