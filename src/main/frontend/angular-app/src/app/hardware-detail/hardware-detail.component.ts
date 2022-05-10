import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Hardware} from '../hardware';
import {ActivatedRoute} from "@angular/router";
import {HardwareService} from "../hardware.service";
import {switchMap} from "rxjs";
import { ReviewService } from '../review.service';
import { Review } from '../review';

@Component({
  selector: 'app-hardware-detail',
  templateUrl: './hardware-detail.component.html',
  styleUrls: ['./hardware-detail.component.css']
})
export class HardwareDetailComponent implements OnInit, OnDestroy {

  hardware: Hardware | undefined;
  reviews: Review[] | undefined;

  constructor(private route: ActivatedRoute, private hardwareService: HardwareService, private reviewService: ReviewService) {
  }

  ngOnInit(): void {
    this.route.params.pipe(
      switchMap(params => {
        return this.hardwareService.getHardwareByCode(params["code"]);
      })
    ).subscribe((hardware: Hardware) => {
      this.hardware = hardware;
      this.reviewService.getReviewsByHardwareCode(this.hardware.code)
        .subscribe(reviews => this.reviews = reviews);
    });
  }

  ngOnDestroy(): void {

  }
}
