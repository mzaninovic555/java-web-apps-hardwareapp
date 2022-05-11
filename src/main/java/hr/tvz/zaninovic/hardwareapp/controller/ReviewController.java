package hr.tvz.zaninovic.hardwareapp.controller;

import hr.tvz.zaninovic.hardwareapp.domain.ReviewDTO;
import hr.tvz.zaninovic.hardwareapp.service.ReviewService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public List<ReviewDTO> getAllReviews() {
    return reviewService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReviewDTO> getReviewById(@PathVariable final Integer id) {
    return reviewService
        .findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping(params = "code")
  public List<ReviewDTO> getAllByHardwareCode(@RequestParam final String code) {
    return reviewService.findAllByHardwareCode(code);
  }

  @GetMapping(params = "content")
  public List<ReviewDTO> getAllByContentContains(@RequestParam final String content) {
    return reviewService.findAllByContentContains(content);
  }
}
