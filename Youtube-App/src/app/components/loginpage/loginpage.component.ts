import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  username: string;
  password: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
      // redirect if user already logged in
      if (localStorage.getItem('currentUser') !== null) {
          this.router.navigate(['../']);
      }
  }

  login() {
    if (this.username !== '' && this.password !== '') {
        this.userService.login(this.username, this.password)
        this.router.navigate(['../']);
    }
  }


}
