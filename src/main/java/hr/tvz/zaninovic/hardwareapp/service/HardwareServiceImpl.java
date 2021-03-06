package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.command.HardwareCommand;
import hr.tvz.zaninovic.hardwareapp.domain.Hardware;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareDTO;
import hr.tvz.zaninovic.hardwareapp.repository.HardwareRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

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
  public Optional<HardwareDTO> findByCode(final String code) {
    return hardwareRepository
        .findByCode(code)
        .map(this::mapHardwareToDTO);
  }

  @Override
  public Optional<HardwareDTO> save(final HardwareCommand hardwareCommand) {
    return hardwareRepository
        .save(mapCommandToHardware(hardwareCommand))
        .map(this::mapHardwareToDTO);
  }

  @Override
  public Optional<HardwareDTO> update(String code, HardwareCommand hardwareCommand) {
    return hardwareRepository
        .update(code, mapCommandToHardware(hardwareCommand))
        .map(this::mapHardwareToDTO);
  }

  @Override
  public void deleteByCode(final String code) {
    hardwareRepository.deleteByCode(code);
  }

  public HardwareDTO mapHardwareToDTO(Hardware hardware) {
    return new HardwareDTO(hardware.getCode(), hardware.getName(), hardware.getPrice());
  }

  public Hardware mapCommandToHardware(final HardwareCommand hardwareCommand) {
    return new Hardware(
        hardwareCommand.getCode(),
        hardwareCommand.getName(),
        hardwareCommand.getPrice(),
        hardwareCommand.getHardwareType(),
        hardwareCommand.getAmount());
  }
}
