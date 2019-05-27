import { Component, OnInit } from '@angular/core';
import {Video} from '../../models/Video';
import {FormControl} from '@angular/forms';
import {VideoService} from '../../services/video.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {


  results: Video[] = [];
  queryField: FormControl = new FormControl();
  constructor(private videoservice: VideoService, private router: Router) { }

  ngOnInit() {
      this.queryField.valueChanges.subscribe( result => this.videoservice.search(result).subscribe(videos => {
        this.results = videos;
      }));
  }

  selectVideo(id: number) {
    this.results.length = 0;
    this.router.navigate(['video', id]);
  }

}
