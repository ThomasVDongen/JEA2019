import { Component, OnInit } from '@angular/core';
import {Video} from '../../models/Video';
import {ReactionService} from '../../services/reaction.service';
import {Reaction} from '../../models/Reaction';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {VideoService} from '../../services/video.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-video-page',
  templateUrl: './video-page.component.html',
  styleUrls: ['./video-page.component.css']
})
export class VideoPageComponent implements OnInit {
  video: Video;
  reactions: Reaction[];
  creator: User;
  currentUser: User;
  r: Reaction;
  form: FormGroup;

  constructor(private reactionService: ReactionService, private userService: UserService, private videoService: VideoService, private router: Router, private route: ActivatedRoute, private formBuilder: FormBuilder) { }

  ngOnInit() {
      this.r = new Reaction();
      this.form = this.formBuilder.group({
          reactionField: new FormControl('', Validators.required)
      });

      this.route.params.subscribe(params =>  {
        this.loadVideo(params.id);

    });


  }
    selectUser(id: number)  {
        this.router.navigate(['/profile', id]);
    }

    async loadVideo(id: number) {
      this.video = await this.videoService.increaseViews(id);
      this.creator = await this.userService.getUser(this.video.uploaderId);
      this.getCurrentUser();
      this.getReactions();

    }
    getCurrentUser() {
        this.userService.currentUser.subscribe(user => {
            this.currentUser = user;
        });
    }
    getReactions() {
        this.reactionService.getReactionsByVideo(this.video.id).subscribe(reactions => {
            this.reactions = reactions;
        });
    }

    createReaction() {
        if (!this.form.invalid) {
            this.r.text = this.form.controls.reactionField.value;
            this.r.senderId = this.currentUser.id;
            this.r.videoId = this.video.id;
            this.r.senderName = this.currentUser.name;
            this.reactionService.create(this.r).subscribe(reactions => {
                this.reactions = reactions;
            });
        } else {
            alert('Need to add text first');
        }
    }

}
