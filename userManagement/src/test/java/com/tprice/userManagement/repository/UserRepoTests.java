package com.tprice.userManagement.repository;

import com.tprice.userManagement.TestHelper;
import com.tprice.userManagement.model.User;
import com.tprice.userManagement.repo.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;


import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTests {

    @Autowired
    private TestEntityManager entityManager;

    private TestHelper testHelper = new TestHelper();

    @Autowired
    private UserRepo userRepo;

    @Test
    public void GetAllUsersToReturnListOfUsers() throws Exception {
        List<User> userList = testHelper.CreateMultipleUsers();
        userList.forEach(user -> this.entityManager.persist(user));
//        userList.forEach(this.entityManager::persist);
        List<User> users = this.userRepo.findAll();
        assertThat(userList.size()).isEqualTo(users.size());
    }
}
