import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {User} from '../models/User';
import {Register} from '../models/Register';

@Injectable({
  providedIn: 'root'
})
export class UserService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;



    private url: string;
    private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
    private jsonHeaders = new HttpHeaders({'Content-Type': 'application/json'});


    constructor(private http: HttpClient) {
      this.url = 'http://localhost:8080/YouTube/api/user/';
      this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
      this.currentUser = this.currentUserSubject.asObservable();
  }

    login(username: string, password: string) {
        const body = new HttpParams()
            .set('username', username)
            .set('password', password);
        return this.http.post<User>(this.url + 'login', body.toString(), {headers: this.headers})
            .subscribe(user => {
                this.setSession(user);
                this.currentUserSubject.next(user);
                }, error1 => {
                alert('Wrong credentials');
            });
    }


    private setSession(user) {
        localStorage.setItem('token', user.token);
        localStorage.setItem('currentUser', JSON.stringify(user));
    }

    logout() {
        this.currentUserSubject.next(null);
        localStorage.removeItem('token');
        localStorage.removeItem('currentUser');
        localStorage.removeItem('selectedUser');
        localStorage.removeItem('selectedVideo');
    }

    getUser(id: number) {
        return this.http.get<User>(this.url + id ).toPromise<User>();
    }

    register(register: Register): Observable<User> {
      return this.http.post<User>(this.url + 'register', register, {headers: this.jsonHeaders});
    }

    subscribe(userId: number, currentUser: number): Observable<any> {
        const body = new HttpParams()
            .set('userId', userId.toString()).set('currentUser', currentUser.toString());
        return this.http.post<any>(this.url + 'subscribe', body.toString(), {headers: this.headers});
    }

    unsubscribe(userId: number, currentUser: number): Observable<any> {
        const body = new HttpParams()
            .set('userId', userId.toString()).set('currentUser', currentUser.toString());
        return this.http.post<any>(this.url + 'unsubscribe', body, {headers: this.headers});
    }

    getSubscribed(id: number, currentUser: number): Observable<boolean> {
        const body = new HttpParams()
            .set('userId', id.toString()).set('currentUser', currentUser.toString());
        return this.http.get<boolean>(this.url + 'subscribed', {params: body} );
    }

    getSubscriberCount(id: number): Observable<number> {
        const body = new HttpParams()
            .set('userId', id.toString());
        return this.http.get<number>(this.url + 'subcount' , {params: body});
    }






}
