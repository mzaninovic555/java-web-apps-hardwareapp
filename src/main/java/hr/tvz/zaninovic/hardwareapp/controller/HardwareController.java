package hr.tvz.zaninovic.hardwareapp.controller;

import hr.tvz.zaninovic.hardwareapp.command.HardwareCommand;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareDTO;
import hr.tvz.zaninovic.hardwareapp.service.HardwareService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController {

  private final HardwareService hardwareService;

  @GetMapping
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public List<HardwareDTO> getAllHardware() {
    return hardwareService.findAll();
  }

  @GetMapping("/{code}")
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable final String code) {
    return hardwareService
        .findByCode(code)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  @Secured({"ROLE_ADMIN"})
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

  @PutMapping("{code}")
  @Secured({"ROLE_ADMIN"})
  public ResponseEntity<HardwareDTO> update(
      @PathVariable final String code,
      @Valid @RequestBody final HardwareCommand hardwareCommand) {
    return hardwareService.update(code, hardwareCommand)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }


  @DeleteMapping("/{code}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Secured({"ROLE_ADMIN"})
  public void delete(@PathVariable String code) {
    hardwareService.deleteByCode(code);
  }
}
