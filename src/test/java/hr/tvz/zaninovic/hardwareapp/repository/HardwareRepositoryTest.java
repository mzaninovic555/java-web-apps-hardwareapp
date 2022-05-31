package hr.tvz.zaninovic.hardwareapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import hr.tvz.zaninovic.hardwareapp.domain.Hardware;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class HardwareRepositoryTest {

  @Autowired
  HardwareRepository hardwareRepository;

  private final Hardware testHardware =
      new Hardware("5", "test", 99.99, HardwareType.CPU, 10);

  @BeforeAll
  public void setUp() {
    hardwareRepository.save(testHardware);
  }

  @Test
  void findAll() {
    List<Hardware> foundHardware = hardwareRepository.findAll();

    assertEquals(foundHardware.size(), 5);
    assertEquals(foundHardware.get(foundHardware.size() - 1), testHardware);
  }

  @Test
  void findByCode() {
    Optional<Hardware> foundHardware = hardwareRepository.findByCode(testHardware.getCode());

    assertTrue(foundHardware.isPresent());
    assertEquals(foundHardware.get(), testHardware);
  }

  @Test
  @Transactional
  void save() {
    Hardware testSaveHardware =
        new Hardware("6", "test", 99.99, HardwareType.CPU, 10);
    hardwareRepository.save(testSaveHardware);

    Optional<Hardware> foundByCode = hardwareRepository.findByCode(testSaveHardware.getCode());

    assertTrue(foundByCode.isPresent());
    assertEquals(foundByCode.get(), testSaveHardware);
  }

  @Test
  @Transactional
  void update() {
    testHardware.setHardwareType(HardwareType.RAM);
    testHardware.setAmount(1000);
    testHardware.setPrice(129.99);
    testHardware.setName("paziUpdate");

    hardwareRepository.update(testHardware.getCode(), testHardware);

    Optional<Hardware> foundUpdate = hardwareRepository.findByCode(testHardware.getCode());

    assertTrue(foundUpdate.isPresent());
    assertEquals(testHardware, foundUpdate.get());
  }

  @Test
  @Transactional
  void deleteByCode() {
    hardwareRepository.deleteByCode(testHardware.getCode());
    List<Hardware> foundAll = hardwareRepository.findAll();

    assertEquals(foundAll.size(), 4);
    assertFalse(foundAll.stream().anyMatch(h -> h.equals(testHardware)));
  }
}