package com.restapi.fakestoreapiproxy.inheritancePractice.Single_table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STUserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findUserById(long id);
}
