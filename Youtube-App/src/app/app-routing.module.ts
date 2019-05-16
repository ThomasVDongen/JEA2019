import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginpageComponent} from './components/loginpage/loginpage.component';
import {HomepageComponent} from './components/homepage/homepage.component';
import {UploadpageComponent} from './components/uploadpage/uploadpage.component';
import {ProfilepageComponent} from './components/profilepage/profilepage.component';
import {PlaylistpageComponent} from './components/playlistpage/playlistpage.component';

const routes: Routes = [
    { path:  'login', component: LoginpageComponent},
    { path: 'homepage', component: HomepageComponent},
    { path: 'upload', component: UploadpageComponent},
    { path: 'profile', component: ProfilepageComponent},
    { path: 'playlist', component: PlaylistpageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
