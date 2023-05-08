package com.codewithGaurav.fullstackbackend.Repository;

import com.codewithGaurav.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


    User getByEmail(String email);

    User findByname(String name);

    List<User> findByEmailAndName(String email, String name);

}
