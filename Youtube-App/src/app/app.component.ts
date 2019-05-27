import { Component } from '@angular/core';
import {UserService} from './services/user.service';
import {User} from './models/User';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Youtube-App';
  currentUser: User;

    constructor(private userService: UserService, private router: Router) {
       this.userService.currentUser.subscribe(user => this.currentUser = user);

    }

    logout() {
        this.userService.logout();
        this.currentUser = null;
        this.router.navigateByUrl('/RefrshComponent', {skipLocationChange: true}).then(() =>
            this.router.navigate(['home']));
    }


    profilePage() {
        this.router.navigate(['/profile', this.currentUser.id]);
    }

    search(queryString: string) {

    }


}
