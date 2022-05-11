import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HardwareComponent} from './hardware/hardware.component';
import {HardwareDetailComponent} from './hardware-detail/hardware-detail.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import { ReviewDetailComponent } from './review-detail/review-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HardwareComponent,
    HardwareDetailComponent,
    ReviewDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
