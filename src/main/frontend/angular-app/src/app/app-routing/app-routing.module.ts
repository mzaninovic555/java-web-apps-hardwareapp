import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HardwareComponent} from "../hardware/hardware.component";
import {HardwareDetailComponent} from "../hardware-detail/hardware-detail.component";
import { ReviewDetailComponent } from '../review-detail/review-detail.component';
import { ReviewComponent } from '../review/review.component';

export const routes: Routes = [
  {path: 'hardware', component: HardwareComponent},
  {path: 'hardware/details/:code', component: HardwareDetailComponent},
  {path: 'review', component: ReviewComponent},
  {path: 'review/:id', component: ReviewDetailComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
