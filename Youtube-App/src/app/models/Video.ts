import {DatePipe} from '@angular/common';
import {VideoStatus} from '../util/video-status.enum';

export class Video {
    id: number;
    name: string;
    description: string;
    views: number;
    uploadTime: DatePipe;
    uploaderName: string;
    uploaderId: number;
    videoStatus: VideoStatus;
}
