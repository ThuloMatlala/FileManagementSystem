package com.tprice.userManagement.repo;

import com.tprice.userManagement.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
