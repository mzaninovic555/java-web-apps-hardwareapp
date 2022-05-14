package hr.tvz.zaninovic.hardwareapp.repository;

import hr.tvz.zaninovic.hardwareapp.domain.Hardware;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MockHardwareRepository implements HardwareRepository {

  private final List<Hardware> MOCK_HARDWARE = new ArrayList<>(Arrays.asList(
      new Hardware("1", "Intel Core i7 11700", 323.99, HardwareType.CPU, 2),
      new Hardware("2", "Kingston NV1 1TB NVME SSD", 89.99, HardwareType.STORAGE, 12),
      new Hardware("3", "Corsair Vengeance LPX DDR4 2x8GB 3200MHz", 99.99, HardwareType.RAM, 23),
      new Hardware("4", "Nvidia GTX 1060 6GB", 199.99, HardwareType.RAM, 7))
  );

  @Override
  public List<Hardware> findAll() {
    return MOCK_HARDWARE;
  }

  @Override
  public Optional<Hardware> findByCode(String code) {
    return MOCK_HARDWARE
        .stream()
        .filter(h -> h.getCode().equals(code))
        .findAny();
  }

  @Override
  public Optional<Hardware> save(Hardware hardware) {
    if (!MOCK_HARDWARE.contains(hardware)) {
      MOCK_HARDWARE.add(hardware);
      return Optional.of(hardware);
    } else {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Hardware> update(String code, Hardware hardware) {
    //TODO implementacija mock update
    return null;
  }

  @Override
  public void deleteByCode(String code) {
    MOCK_HARDWARE.removeIf(h -> h.getCode().equals(code));
  }
}
