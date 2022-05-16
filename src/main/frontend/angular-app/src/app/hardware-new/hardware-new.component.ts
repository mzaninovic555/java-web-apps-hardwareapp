import {Component} from '@angular/core';
import {Hardware} from "../hardware";
import {HardwareService} from "../hardware.service";
import {Location} from "@angular/common";
import {Router} from '@angular/router';

@Component({
  selector: 'app-hardware-new',
  templateUrl: './hardware-new.component.html',
  styleUrls: ['./hardware-new.component.css']
})
export class HardwareNewComponent {
  constructor(
    private hardwareService: HardwareService,
    private router: Router,
    private location: Location
  ) {
  }

  add(code: string, name: string, hardwareType: string, stock: number, price: number): void {
    code = code.trim();
    name = name.trim();
    hardwareType = hardwareType.trim();
    if (!code || !name || !hardwareType) {
      return;
    }

    this.hardwareService.addHardware({code, name, hardwareType, stock, price} as Hardware)
      .subscribe(
        () => {
          this.router.navigate(['/hardwares']).then();
        }
      );
  }

  goBack(): void {
    this.location.back();
  }

}
