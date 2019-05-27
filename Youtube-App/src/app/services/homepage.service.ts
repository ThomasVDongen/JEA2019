import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Video} from '../models/Video';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HomepageService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/YouTube/api/video/';
  }

    getTrendingVideos(): Observable<Video[]> {
        return this.http.get<Video[]>(this.url + 'trending');
    }

    getPublicVideos(): Observable<Video[]> {
        return this.http.get<Video[]>(this.url + 'public');
    }
}
