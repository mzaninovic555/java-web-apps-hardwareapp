import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';
import { Hardware } from '../hardware';
import { HardwareService } from '../hardware.service';
import { Review } from '../review';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-review-detail',
  templateUrl: './review-detail.component.html',
  styleUrls: ['./review-detail.component.css'],
})
export class ReviewDetailComponent implements OnInit {
  review: Review | undefined;
  hardware: Hardware | undefined;

  constructor(
    private route: ActivatedRoute,
    private reviewService: ReviewService,
    private hardwareService: HardwareService
  ) {}

  ngOnInit(): void {
    this.route.params.pipe(
      switchMap(params => {
        return this.reviewService.getReviewById(params["id"]);
      })
    ).subscribe((review: Review) => {
      this.review = review;
      this.hardwareService.getHardwareByCode(review.hardwareId)
        .subscribe(hardware => this.hardware = hardware);
    });
  }
}
