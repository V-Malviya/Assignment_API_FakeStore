package com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTUserRepository extends JpaRepository<User,Long> {
    User save(User u);
    User findUserById(long id);
}
