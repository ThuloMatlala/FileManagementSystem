package com.tprice.userManagement.repo;

import com.tprice.userManagement.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepo extends CrudRepository<User, Long> {
}
