package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
