import { Component, OnInit } from '@angular/core';
import {VideoService} from '../../services/video.service';
import {ActivatedRoute, Router, UrlSerializer} from '@angular/router';
import {User} from '../../models/User';
import {Video} from '../../models/Video';
import {UserService} from '../../services/user.service';
import {getInlineResourcesTransformFactory} from '@angular/compiler-cli/src/transformers/inline_resources';

@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrls: ['./profilepage.component.css']
})
export class ProfilepageComponent implements OnInit {

  constructor(private videoService: VideoService, private route: ActivatedRoute, private router: Router, private userService: UserService) { }
  currentUser: User;
  userVideos: Video[];
  selectedUser: User;
  sameUser: boolean;
  subscribed: boolean;
  buttonText: string;

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.loadProfile(params.id);
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
        }
        return output;
    }

    subscribe(): void {
        if (this.subscribed === false) {
            this.userService.subscribe(this.selectedUser.id, this.currentUser.id).subscribe(response => {
                this.subscribed = true;
                this.getSubscriberCount();
            });
        }
    }
     unsubscribe(): void {
         this.userService.unsubscribe(this.selectedUser.id, this.currentUser.id).subscribe(response => {
             this.subscribed = false;
             this.getSubscriberCount();

         });
     }

     selectVideo(id: number) {
        this.router.navigate(['/video', id]);
    }

     selectUser(id: number)  {
        this.router.navigate(['/profile', id]);
    }

    async loadProfile(id: number) {
      this.selectedUser = await this.userService.getUser(id);
      this.getCurrentUser();

    }

     getCurrentUser() {
        this.userService.currentUser.subscribe(user => {
            if (user) {
                this.currentUser = user;
                this.sameUser = this.currentUser.id === this.selectedUser.id;
            }
            this.getVideoFromUser();
            this.getSubscribed();
        });
    }

     getVideoFromUser() {
        this.videoService.getVideosFromUser(this.selectedUser.id).subscribe(videos => {
            this.userVideos = videos;
        });
    }

     getSubscribed() {
        this.userService.getSubscribed(this.selectedUser.id, this.currentUser.id).subscribe(value => {
            console.log(value);
            this.subscribed = value;
        });
    }
     getSubscriberCount() {
        this.userService.getSubscriberCount(this.selectedUser.id).subscribe(int => {
            this.selectedUser.subscriberCount = int;
            console.log(int);
        });
    }

}
