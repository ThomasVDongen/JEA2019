import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FlexLayoutModule} from '@angular/flex-layout';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { UploadpageComponent } from './components/uploadpage/uploadpage.component';
import { ProfilepageComponent } from './components/profilepage/profilepage.component';
import { PlaylistpageComponent } from './components/playlistpage/playlistpage.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { VideoPageComponent } from './components/video-page/video-page.component';
import { RegisterComponent } from './components/register/register.component';
import { DatePickerModule } from '@syncfusion/ej2-angular-calendars';
import { SearchComponent } from './components/search/search.component';
import {JwtInterceptor} from './helpers/JwtInterceptor';
import {SocketService} from './services/socket.service';
import {UserService} from './services/user.service';
import {VideoService} from './services/video.service';
import {ReactionService} from './services/reaction.service';

export function tokenGetter() {
    return localStorage.getItem('token');
}

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginpageComponent,
    UploadpageComponent,
    ProfilepageComponent,
    PlaylistpageComponent,
    VideoPageComponent,
    RegisterComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule, DatePickerModule, FlexLayoutModule, ReactiveFormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true}, UserService, VideoService, ReactionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
