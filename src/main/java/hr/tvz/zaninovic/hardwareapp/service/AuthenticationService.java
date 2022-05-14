package hr.tvz.zaninovic.hardwareapp.service;


import hr.tvz.zaninovic.hardwareapp.domain.LoginDTO;
import hr.tvz.zaninovic.hardwareapp.command.LoginCommand;
import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
