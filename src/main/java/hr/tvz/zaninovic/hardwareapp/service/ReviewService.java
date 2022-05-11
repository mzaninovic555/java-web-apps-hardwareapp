package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.domain.ReviewDTO;
import java.util.List;
import java.util.Optional;

public interface ReviewService {

  List<ReviewDTO> findAll();

  Optional<ReviewDTO> findById(Integer id);

  List<ReviewDTO> findAllByHardwareCode(String hardwareCode);

  List<ReviewDTO> findAllByContentContains(String content);
}
