package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.command.LoginCommand;
import hr.tvz.zaninovic.hardwareapp.domain.LoginDTO;
import hr.tvz.zaninovic.hardwareapp.domain.User;
import hr.tvz.zaninovic.hardwareapp.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  private final JwtService jwtService;
  private final UserRepository userRepository;

  public AuthenticationServiceImpl(JwtService jwtService, UserRepository userRepository) {
    this.jwtService = jwtService;
    this.userRepository = userRepository;
  }

  @Override
  public Optional<LoginDTO> login(LoginCommand command) {
    Optional<User> user = userRepository.findByUsername(command.getUsername());

    if (user.isEmpty() || !isMatchingPassword(command.getPassword(), user.get().getPassword())) {
      return Optional.empty();
    }

    return Optional.of(
        new LoginDTO(jwtService.createJwt(user.get()))
    );
  }

  private boolean isMatchingPassword(String rawPassword, String encryptedPassword) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return bCryptPasswordEncoder.matches(rawPassword, encryptedPassword);
  }
}
