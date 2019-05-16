import {DatePipe} from '@angular/common';

export class User  {
    id: number;
    name: string;
    email: string;
    birthday: DatePipe;
    role: string;
    url: string;
    videoCount: number;
    subscriberCount: number;
    subscribedCount: number;

}