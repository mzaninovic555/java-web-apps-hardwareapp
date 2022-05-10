package hr.tvz.zaninovic.hardwareapp.repository;

import hr.tvz.zaninovic.hardwareapp.domain.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAReviewRepository extends JpaRepository<Review, Integer> {

  List<Review> findAll();

  List<Review> findAllByHardwareCode(String hardwareCode);
}
