package com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCUserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findUserById(long id);
}
