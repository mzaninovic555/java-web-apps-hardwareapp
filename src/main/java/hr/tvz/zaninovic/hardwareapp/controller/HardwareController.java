package hr.tvz.zaninovic.hardwareapp.controller;

import hr.tvz.zaninovic.hardwareapp.domain.HardwareDTO;
import hr.tvz.zaninovic.hardwareapp.service.HardwareService;
import hr.tvz.zaninovic.hardwareapp.command.HardwareCommand;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController {

  private final HardwareService hardwareService;

  public HardwareController(HardwareService hardwareService) {
    this.hardwareService = hardwareService;
  }

  @GetMapping
  public List<HardwareDTO> getAllHardware() {
    return hardwareService.findAll();
  }

  @GetMapping("/{code}")
  public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable final String code) {
    return hardwareService
        .findByCode(code)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<HardwareDTO> save(
      @Valid @RequestBody final HardwareCommand hardwareCommand) {
    return hardwareService
        .save(hardwareCommand)
        .map(
            hDTO -> ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hDTO))
        .orElseGet(
            () -> ResponseEntity
                .status(HttpStatus.CONFLICT)
                .build()
        );
  }

  @DeleteMapping("/{code}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable String code) {
    hardwareService.deleteByCode(code);
  }
}
