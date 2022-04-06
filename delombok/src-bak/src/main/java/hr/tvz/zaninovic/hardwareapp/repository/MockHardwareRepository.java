package hr.tvz.zaninovic.hardwareapp.repository;

import hr.tvz.zaninovic.hardwareapp.domain.Hardware;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MockHardwareRepository implements HardwareRepository {
    private final List<Hardware> MOCK_HARDWARE = Arrays.asList(
            new Hardware("Intel Core i7 11700", "1", 323.99, HardwareType.CPU, 2),
            new Hardware("Kingston NV1 1TB NVME SSD", "2", 89.99, HardwareType.STORAGE,12),
            new Hardware("Corsair Vengeance LPX DDR4 2x8GB 3200MHz", "3", 99.99, HardwareType.RAM, 23),
            new Hardware("Nvidia GTX 1060 6GB", "4", 199.99, HardwareType.RAM, 23)
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
        if(!MOCK_HARDWARE.contains(hardware)){
            MOCK_HARDWARE.add(hardware);
            return Optional.of(hardware);
        }
        else{
            return Optional.empty();
        }
    }
}
