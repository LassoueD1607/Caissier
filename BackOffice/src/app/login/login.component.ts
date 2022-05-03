import { Router } from '@angular/router';
import { AuthService } from './../services/auth.service';
import { Admin } from './../model/admin';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent implements OnInit {
  user = new Admin();
  erreur = 0;

  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }
  onLoggedin() {

    let isValidUser: Boolean = this.authService.SignIn(this.user);
    if (isValidUser)
      this.router.navigate(['/']);
    else
      this.erreur = 1
  }


}
