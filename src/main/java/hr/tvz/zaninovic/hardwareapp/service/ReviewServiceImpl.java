package hr.tvz.zaninovic.hardwareapp.service;

import hr.tvz.zaninovic.hardwareapp.domain.Review;
import hr.tvz.zaninovic.hardwareapp.domain.ReviewDTO;
import hr.tvz.zaninovic.hardwareapp.repository.JPAReviewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

  private final JPAReviewRepository jpaReviewRepository;

  public ReviewServiceImpl(JPAReviewRepository jpaReviewRepository) {
    this.jpaReviewRepository = jpaReviewRepository;
  }

  @Override
  public List<ReviewDTO> findAll() {
    return jpaReviewRepository.findAll().stream().map(this::mapReviewToDTO).toList();
  }

  @Override
  public Optional<ReviewDTO> findById(final Integer id) {
    return jpaReviewRepository.findById(id).map(this::mapReviewToDTO);
  }

  @Override
  public List<ReviewDTO> findAllByHardwareCode(String hardwareCode) {
    return jpaReviewRepository.findAllByHardwareCode(hardwareCode).stream()
        .map(this::mapReviewToDTO).toList();
  }

  @Override
  public List<ReviewDTO> findAllByContentContains(String content) {
    return jpaReviewRepository.findAllByContentContainingIgnoreCase(content).stream()
        .map(this::mapReviewToDTO).toList();
  }

  public ReviewDTO mapReviewToDTO(Review review) {
    return new ReviewDTO(review.getId(), review.getTitle(), review.getContent(), review.getGrade(),
        review.getHardware().getCode());
  }
}
