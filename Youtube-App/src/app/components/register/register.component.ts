import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {User} from '../../models/User';
import {Register} from '../../models/Register';
import {Router} from '@angular/router';
import {FormBuilder, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User;
  register: Register;
  password1: string;
  password2: string;

  constructor(private userService: UserService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {

      this.user = new User();
      this.user.role = 'user';
      this.user.subscribedCount = 0;
      this.user.subscriberCount = 0;
      this.user.token = '';
      this.user.videoCount = 0;
  }

  registerUser() {
    if (this.password1 === this.password2) {
      console.log(this.user.birthday);
      this.register = new Register();
      this.register.user = this.user;
      this.register.password = this.password1;
      this.userService.register(this.register).subscribe(user => {
          this.router.navigateByUrl('/home');
      });
    } else {
      alert('Passwords do not match');
    }
  }

}
