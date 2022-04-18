import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HardwareComponent} from "../hardware/hardware.component";
import {HardwareDetailComponent} from "../hardware-detail/hardware-detail.component";

export const routes: Routes = [
  {path: 'hardware', component: HardwareComponent},
  {path: 'hardware/details/:code', component: HardwareDetailComponent}
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
