import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reaction} from '../models/Reaction';

@Injectable({
  providedIn: 'root'
})
export class ReactionService {
    url: string;
    private jsonHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {
      this.url = 'http://localhost:8080/YouTube/api/reaction/';
  }

    getReactionsByVideo(id: number): Observable<Reaction[]> {
      const httpParams = new HttpParams()
          .set('videoId', id.toString());
      return this.http.get<Reaction[]>(this.url + 'video', {params: httpParams});
    }

    create(r: Reaction): Observable<any> {
        return this.http.post(this.url + 'create', r, {headers: this.jsonHeaders});
    }
}
