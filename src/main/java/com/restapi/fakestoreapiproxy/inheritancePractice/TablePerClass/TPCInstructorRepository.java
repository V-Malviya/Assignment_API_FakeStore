package com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCInstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save(Instructor instructor);
    Instructor findInstructorById(long id);
}
