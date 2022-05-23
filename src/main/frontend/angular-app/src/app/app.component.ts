import { Component } from '@angular/core';
import { AuthenticationService } from './security/authentication.service';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Hardware App';
  currentLanguage: string;

  constructor(
    public authenticationService: AuthenticationService,
    private router: Router,
    private translate: TranslateService
  ) {
    translate.setDefaultLang('hr');
    translate.use('hr');
    this.currentLanguage = translate.currentLang;
  }

  changeLanguage(): void {
    switch(this.translate.currentLang){
      case 'hr':
        this.translate.use('en');
        this.currentLanguage = 'en';
        break;
      case 'en':
        this.translate.use('hr');
        this.currentLanguage = 'hr';
        break;
    }
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']).then();
  }
}
