package hr.tvz.zaninovic.hardwareapp.controller;

import hr.tvz.zaninovic.hardwareapp.domain.ReviewDTO;
import hr.tvz.zaninovic.hardwareapp.service.ReviewService;
import java.util.List;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public List<ReviewDTO> getAllReviews() {
    return reviewService.findAll();
  }

  @GetMapping(params = "code")
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public List<ReviewDTO> getAllByHardwareCode(@RequestParam final String code) {
    return reviewService.findAllByHardwareCode(code);
  }
}
