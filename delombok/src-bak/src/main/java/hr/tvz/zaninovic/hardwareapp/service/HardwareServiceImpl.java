package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.domain.Hardware;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareDTO;
import hr.tvz.zaninovic.hardwareapp.repository.HardwareRepository;
import hr.tvz.zaninovic.hardwareapp.command.HardwareCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {
    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll()
                .stream()
                .map(this::mapHardwareToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HardwareDTO findByCode(String code) {
        return hardwareRepository.findByCode(code)
                .map(this::mapHardwareToDTO)
                .orElse(null);
    }

    @Override
    public Optional<HardwareDTO> save(HardwareCommand hardwareCommand) {
        return Optional.empty();
    }

    public HardwareDTO mapHardwareToDTO(Hardware hardware){
        return new HardwareDTO(hardware.getName(), hardware.getPrice());
    }
}
