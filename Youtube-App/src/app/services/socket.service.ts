import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../models/User';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root'
})
export class SocketService {

    websocket: WebSocket;
    currentUser: User;

    constructor(private userService: UserService) {
        this.userService.currentUser.subscribe(user => {
            this.currentUser = user;
        });
    }

    createObservableSocket(): Observable<any> {
        this.websocket = new WebSocket('ws://localhost:8080/YouTube/api/socket/');
        return new Observable(observer => {
            this.websocket.onmessage = event => observer.next(event.data);
            this.websocket.onerror = event => observer.error(event);
            this.websocket.onclose = event => observer.complete();
            this.websocket.onopen = event => console.log('Connected to websocket');

            return () => this.websocket.close();
        });
    }



}
