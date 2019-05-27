import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Video} from '../models/Video';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VideoService {
  private url: string;
  private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
  private jsonHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/YouTube/api/video/';
  }



  increaseViews(videoId: number) {
      const body = new HttpParams()
          .set('videoId', videoId.toString());
      return this.http.post<Video>(this.url + 'view', body.toString(), {headers: this.headers}).toPromise();
  }


  getSubscriptions(userId: number): Observable<Video[]> {
      const body = new HttpParams()
          .set('userId', userId.toString());
      return this.http.get<Video[]>(this.url + 'sub', {params: body} );
  }

  upload(video: Video): Observable<void> {
      return this.http.post<void >(this.url + 'upload', video, {headers: this.jsonHeaders});
  }

  getVideosFromUser(userId: number): Observable<Video[]> {
      const body = new HttpParams()
          .set('userId', userId.toString());
      return this.http.get<Video[]>(this.url + 'user', {params: body} );
  }

  search(title: string): Observable<Video[]> {
      const body = new HttpParams()
          .set('search', title);
      console.log(title);
      return this.http.get<Video[]>(this.url + 'search', {params: body});
  }

}
