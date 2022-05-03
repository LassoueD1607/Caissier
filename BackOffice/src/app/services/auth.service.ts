import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { Admin } from './../model/admin';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiURL: string = 'http://localhost:8080/admin';
  //users: Admin[] = [{ "idAdmin": 1, "adminName": "admin", "password": "admin" }]
  public loggedUser: string = "";
  public isloggedIn: Boolean = false;
  admins!: Admin[]



  constructor(private router: Router, private http: HttpClient) {
    this.http.get<Admin[]>(this.apiURL).subscribe(adm => {

      this.admins = adm;




    });
  }
  SignIn(user: Admin): Boolean {
    let validUser: Boolean = false;
    this.admins.forEach((curUser) => {
      if (user.adminName === curUser.adminName && user.password == curUser.password) {
        validUser = true;
        this.loggedUser = curUser.adminName;
        this.isloggedIn = true;
        //localStorage.setItem('loggedUser', this.loggedUser);
        //localStorage.setItem('isloggedIn', String(this.isloggedIn));
      }
    });
    return validUser;
  }
  logout() {
    this.isloggedIn = false;
    this.loggedUser = "";

    //localStorage.removeItem('loggedUser');
    //localStorage.setItem('isloggedIn', String(this.isloggedIn));
    this.router.navigate(['/login']);
  }
  /*setLoggedUserFromLocalStorage(login: string) {
    this.loggedUser = login;
    this.isloggedIn = true;

  }*/




}
