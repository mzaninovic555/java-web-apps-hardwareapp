import { Component, Input, OnInit } from '@angular/core';
import { Hardware } from '../hardware';

@Component({
  selector: 'app-hardware-detail',
  templateUrl: './hardware-detail.component.html',
  styleUrls: ['./hardware-detail.component.css']
})
export class HardwareDetailComponent implements OnInit {

  @Input() hardware: Hardware | undefined;

  constructor() { }

  ngOnInit(): void {
  }
}
