package hr.tvz.zaninovic.hardwareapp.repository;

import hr.tvz.zaninovic.hardwareapp.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    Optional<Hardware> save(Hardware hardwareDTO);
}
