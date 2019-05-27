import { Component, OnInit } from '@angular/core';
import {VideoService} from '../../services/video.service';
import {UserService} from '../../services/user.service';
import {Video} from '../../models/Video';
import {Router} from '@angular/router';
import {User} from '../../models/User';
import {SocketService} from '../../services/socket.service';
import {applySourceSpanToExpressionIfNeeded} from '@angular/compiler/src/output/output_ast';
import {HomepageService} from '../../services/homepage.service';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  publicvideos: Video[];
  subscriptions: Video[];
  trending: Video[];
  currentUser: User;

  constructor(private videoService: VideoService, private userService: UserService, private router: Router, private socketService: SocketService, private homepageService: HomepageService) { }

  ngOnInit() {

    this.userService.currentUser.subscribe(user => {
        this.currentUser = user;
        if (this.currentUser) {
            this.socketService.createObservableSocket().subscribe(video => {
                this.subscriptions.push(JSON.parse(video));
            });
        }
        this.getSubscriptions();
        this.getTrendingVideos();
        this.getpublicVideos();
    });


  }




    calculateTime(uploadTime: Date): string {
      const uploaded = new Date(uploadTime);
      const time = new Date().getTime() - uploaded.getTime();
      return this.msToTime(time);
  }

  private msToTime(duration): string {
        const minutes = Math.floor((duration / (1000 * 60)) % 60);
        const hours = Math.floor((duration / (1000 * 60 * 60)) % 24);
        let output = '';
        if (hours > 0) {
            output = hours.toString() + ' uur';
        }
        if (minutes === 1) {
            output = output + ' ' + minutes.toString() + ' minuut';
        } else if (minutes > 0) {
            output = output + ' ' + minutes.toString() + ' minuten';
        } else {
            output = 'Now';
        }
        return output;
  }

  selectVideo(id: number) {
      this.router.navigate(['/video', id]);
  }

  selectUser(id: number)  {
      this.router.navigate(['/profile', id]);
  }

  getSubscriptions() {
      if (this.currentUser !== null) {
          this.videoService.getSubscriptions(this.currentUser.id).subscribe(videos => {
              this.subscriptions = videos;
          });
      }
  }

  getpublicVideos() {
      this.homepageService.getPublicVideos().subscribe(videos => {
          this.publicvideos = videos;
      });
  }

  getTrendingVideos() {
      this.homepageService.getTrendingVideos().subscribe( vidoes =>  {
          this.trending = vidoes;
      });
  }





}
