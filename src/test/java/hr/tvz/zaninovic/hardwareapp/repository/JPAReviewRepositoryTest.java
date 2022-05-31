package hr.tvz.zaninovic.hardwareapp.repository;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import hr.tvz.zaninovic.hardwareapp.domain.Hardware;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import hr.tvz.zaninovic.hardwareapp.domain.Review;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
class JPAReviewRepositoryTest {

  @Autowired
  JPAReviewRepository jpaReviewRepository;

  @Autowired
  HardwareRepository hardwareRepository;

  private final Hardware hardware =
      new Hardware("1", "Intel Core i7 11700", 323.99, HardwareType.CPU, 2);

  private final Review review =
      new Review(1, "Core i7 11700 review", "Powerful CPU", 5, hardware);

  @Test
  void findAll() {
    List<Review> foundAll = jpaReviewRepository.findAll();

    assertNotEquals(foundAll.size(), 0);
    assertTrue(foundAll.contains(review));
  }

  @Test
  void findAllByHardwareCode() {
    List<Review> foundAll = jpaReviewRepository.findAllByHardwareCode(hardware.getCode());

    assertNotEquals(foundAll.size(), 0);
    assertTrue(foundAll.contains(review));
  }
}