import { Router } from '@angular/router';
import { AuthService } from './services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title: string = 'BackOffice';

  constructor(public authService: AuthService, private router: Router) { }
  ngOnInit() {
    let isloggedin: Boolean;
    let loggedUser: string;
    isloggedin = this.authService.isloggedIn;
    loggedUser = this.authService.loggedUser
    if (isloggedin != true || !loggedUser)
      this.router.navigate(['/login']);

  }

}
