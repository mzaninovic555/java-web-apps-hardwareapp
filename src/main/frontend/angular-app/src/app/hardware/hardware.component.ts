import {Component, OnInit} from '@angular/core';
import {Hardware} from '../hardware';
import {HardwareService} from '../hardware.service';
import {HardwareType} from "../hardware-type";
import { Observable } from 'rxjs';
import { Review } from '../review';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-hardware',
  templateUrl: './hardware.component.html',
  styleUrls: ['./hardware.component.css']
})
export class HardwareComponent implements OnInit {

  hardwares!: Hardware[];
  reviews!: Review[];
  selectedHardware: Hardware | undefined;
  public hardwareTypes = Object.values(HardwareType);

  constructor(private hardwareService: HardwareService, private reviewService: ReviewService) {
  }

  ngOnInit(): void {
    this.getHardwares();
    this.getReviews();
  }

  getHardwares(): void {
    this.hardwareService.getHardwares()
      .subscribe(hardwares => this.hardwares = hardwares);
  }

  getReviews(): void {
    this.reviewService.getReviews()
      .subscribe(reviews => this.reviews = reviews);
  }

  onSelect(hardware: Hardware): void {
    this.selectedHardware = hardware;
  }

  add(code: string, name: string, price: number, hardwareType: string, amount: number): void {
    code = code.trim();
    name = name.trim();

    if(!code || !name || !price || !hardwareType || !amount){
      return;
    }

    this.hardwareService.addHardware({code, name, price, hardwareType, amount} as Hardware)
      .subscribe(hardware => {this.hardwares.push(hardware)})
  }

  getReviewByContent(content: string): void {
    this.reviewService.getReviewsByContent(content)
      .subscribe(reviews => this.reviews = reviews)
  }

  delete(hardware: Hardware){
    this.hardwares = this.hardwares.filter(h => h !== hardware);
    this.hardwareService.deleteHardware(hardware).subscribe();
  }
}
