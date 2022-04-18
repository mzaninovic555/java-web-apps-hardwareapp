import {Component, OnInit} from '@angular/core';
import {Hardware} from '../hardware';
import {HardwareService} from '../hardware.service';

@Component({
  selector: 'app-hardware',
  templateUrl: './hardware.component.html',
  styleUrls: ['./hardware.component.css']
})
export class HardwareComponent implements OnInit {

  hardwares!: Hardware[];
  selectedHardware: Hardware | undefined;


  constructor(private hardwareService: HardwareService) {
  }

  ngOnInit(): void {
    this.getHardwares();
  }

  getHardwares(): void {
    this.hardwareService.getHardwares()
      .subscribe(hardwares => this.hardwares = hardwares);
  }

  onSelect(hardware: Hardware): void {
    this.selectedHardware = hardware;
  }

  add(code: string, name: string, price: number, hardwareType: string, amount: number): void {
    code = code.trim();
    name = name.trim();
    hardwareType = hardwareType.trim();

    if(!code || !name || !price || !hardwareType || !amount){
      return;
    }

    this.hardwareService.addHardware({code, name, price, hardwareType, amount} as Hardware)
      .subscribe(hardware => {this.hardwares.push(hardware)})
  }

  delete(hardware: Hardware){
    this.hardwares = this.hardwares.filter(h => h !== hardware);
    this.hardwareService.deleteHardware(hardware).subscribe();
  }
}
