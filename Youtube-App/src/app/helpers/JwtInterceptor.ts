import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import {UserService} from '../services/user.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

    constructor(private userService: UserService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // adding jwt token

        this.userService.currentUser.subscribe(user => {
            if (user && user.token) {
                request = request.clone({
                    setHeaders : {
                        Authorization: `Bearer ${user.token}`
                    }
                });
                console.log(request.headers);
            }
        });
        return next.handle(request);
    }
}
