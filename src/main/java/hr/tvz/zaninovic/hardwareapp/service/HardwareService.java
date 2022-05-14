package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.command.HardwareCommand;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareDTO;
import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    Optional<HardwareDTO> save(HardwareCommand hardwareCommand);

    Optional<HardwareDTO> update(String code, HardwareCommand hardwareCommand);

    void deleteByCode(String code);
}
