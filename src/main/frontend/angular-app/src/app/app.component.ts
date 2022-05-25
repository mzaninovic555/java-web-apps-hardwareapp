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

  changeLanguage(newLanguage: string): void {
    switch (newLanguage) {
      case 'de':
        this.translate.use('de');
        this.currentLanguage = 'de';
        break;
      case 'en':
        this.translate.use('en');
        this.currentLanguage = 'en';
        break;
      case 'hr':
        this.translate.use('hr');
        this.currentLanguage = 'hr';
        break;
      case 'jp':
        this.translate.use('jp');
        this.currentLanguage = 'jp';
        break;
    }
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']).then();
  }
}
