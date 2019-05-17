import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import {JwtHelperService} from './jwt-helper.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
    url: 'http://localhost:8080/YouTube/api/user/';
    jwtHelper: JwtHelperService = new JwtHelperService();

  constructor(private http: HttpClient) { }

  login(username: string, password: string): void {
    const loginData = {username, password};
    this.http.post(this.url + 'login', {loginData}, {observe: 'response'})
        .pipe(tap((res) => {
            this.setSession(res.headers.get('Authorization').slice(7)); // Slice "Bearer "
        }));
  }
    private setSession(token) {
        localStorage.setItem('token', token);
    }

    logout() {
        localStorage.removeItem('token');
    }

    public isLoggedIn() {
        const token = localStorage.getItem('token');
        return !this.jwtHelper.isTokenExpired(token);
    }

    isLoggedOut() {
        return !this.isLoggedIn();
    }
}
