package hr.tvz.zaninovic.hardwareapp.controller;

import hr.tvz.zaninovic.hardwareapp.domain.HardwareDTO;
import hr.tvz.zaninovic.hardwareapp.service.HardwareService;
import hr.tvz.zaninovic.hardwareapp.command.HardwareCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hardware")
public class HardwareController {
    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardware(){
        return hardwareService.findAll();
    }

    @GetMapping(params = "code")
    public HardwareDTO getHardwareByCode(@RequestParam final String code){
        return hardwareService.findByCode(code);
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand hardwareCommand){
        return hardwareService

    }
}
