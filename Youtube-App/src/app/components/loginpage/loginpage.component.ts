import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  username: string;
  password: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  login(): void {
    this.userService.login(this.username, this.password);
  }


}
