package com.tprice.userManagement.repo;

import com.tprice.userManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserRepo extends JpaRepository<User, Long> {

    List<User> findByLastName(String lastName);

    User findByEmail(String email);
}
