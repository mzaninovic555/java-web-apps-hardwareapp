package hr.tvz.zaninovic.hardwareapp.controller;

import hr.tvz.zaninovic.hardwareapp.command.LoginCommand;
import hr.tvz.zaninovic.hardwareapp.domain.LoginDTO;
import hr.tvz.zaninovic.hardwareapp.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("authentication")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("/login")
  public LoginDTO login(@Valid @RequestBody final LoginCommand command) {
    return authenticationService.login(command)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credentials"));
  }

}
