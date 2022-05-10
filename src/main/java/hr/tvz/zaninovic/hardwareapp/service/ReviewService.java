package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.domain.ReviewDTO;
import java.util.List;

public interface ReviewService {

  List<ReviewDTO> findAll();

  List<ReviewDTO> findAllByHardwareCode(String hardwareCode);
}
