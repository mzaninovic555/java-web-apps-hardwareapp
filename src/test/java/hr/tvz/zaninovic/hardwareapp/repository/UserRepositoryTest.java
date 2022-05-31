package hr.tvz.zaninovic.hardwareapp.repository;

import static org.junit.jupiter.api.Assertions.*;

import hr.tvz.zaninovic.hardwareapp.domain.User;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  void findByUsername() {
    Optional<User> foundByUsername = userRepository.findByUsername("admin");

    assertTrue(foundByUsername.isPresent());
    assertEquals(foundByUsername.get().getUsername(), "admin");
  }
}