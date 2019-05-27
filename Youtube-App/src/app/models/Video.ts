import {DatePipe} from '@angular/common';
import {VideoStatus} from '../util/video-status.enum';

export class Video {
    id: number;
    name: string;
    description: string;
    views: number;
    uploadTime: Date;
    uploaderName: string;
    uploaderId: number;
    status: VideoStatus;
    links: string[];
}
