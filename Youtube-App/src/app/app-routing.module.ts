import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginpageComponent} from './components/loginpage/loginpage.component';
import {HomepageComponent} from './components/homepage/homepage.component';
import {UploadpageComponent} from './components/uploadpage/uploadpage.component';
import {ProfilepageComponent} from './components/profilepage/profilepage.component';
import {PlaylistpageComponent} from './components/playlistpage/playlistpage.component';
import {VideoPageComponent} from './components/video-page/video-page.component';
import {RegisterComponent} from './components/register/register.component';

const routes: Routes = [
    { path:  'login', component: LoginpageComponent},
    { path: 'home', component: HomepageComponent},
    { path: 'upload', component: UploadpageComponent},
    { path: 'profile/:id', component: ProfilepageComponent},
    {path: 'profile', component: ProfilepageComponent},
    { path: 'playlist', component: PlaylistpageComponent},
    { path: 'video/:id', component: VideoPageComponent},
    { path: 'register', component: RegisterComponent},
    { path: '', redirectTo: '/home', pathMatch: 'full'},
    { path: '**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
