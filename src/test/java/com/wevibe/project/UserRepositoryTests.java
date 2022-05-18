package com.wevibe.project;

import com.wevibe.project.users.User;
import com.wevibe.project.users.repository.UserRepositoryInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepositoryInterface repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("mati@gmail.com");
        user.setPassword("mati");
        user.setUsername("mati");
        user.setRoles("USER_ROLE");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getIdUser());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}
