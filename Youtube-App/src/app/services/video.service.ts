import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Video} from '../models/Video';
import {VideoStatus} from '../util/video-status.enum';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VideoService {
  url: 'http://localhost:8080/YouTube/api/video/';

  constructor(private http: HttpClient) { }

  getVideos(): Observable<Video[]> {
    return this.http.get<Video[]>(this.url + 'all');
  }

  getPublicVideos(): Observable<Video[]> {
      return this.http.get<Video[]>(this.url + 'public');
  }
}
