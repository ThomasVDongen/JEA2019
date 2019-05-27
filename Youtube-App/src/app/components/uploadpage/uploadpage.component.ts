import { Component, OnInit } from '@angular/core';
import {VideoService} from '../../services/video.service';
import {User} from '../../models/User';
import {Video} from '../../models/Video';
import {VideoStatus} from '../../util/video-status.enum';
import {Router} from '@angular/router';
import {HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-uploadpage',
  templateUrl: './uploadpage.component.html',
  styleUrls: ['./uploadpage.component.css']
})
export class UploadpageComponent implements OnInit {
  name: string;
  description: string;
  currentUser: User;
  video: Video;

  constructor(private videoService: VideoService, private router: Router) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  upload() {
    console.log(this.currentUser);
    this.video = new Video();
    this.video.id = 1;
    this.video.uploaderId = this.currentUser.id;
    this.video.uploaderName = this.currentUser.name;
    this.video.description = this.description;
    this.video.name = this.name;
    this.video.views = 0;
    this.video.status = VideoStatus.Public;
    this.videoService.upload(this.video).subscribe(response => {
       console.log(response);
        this.router.navigateByUrl('home');
      });
  }

}
