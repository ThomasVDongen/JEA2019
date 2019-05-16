import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { UploadpageComponent } from './components/uploadpage/uploadpage.component';
import { ProfilepageComponent } from './components/profilepage/profilepage.component';
import { PlaylistpageComponent } from './components/playlistpage/playlistpage.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginpageComponent,
    UploadpageComponent,
    ProfilepageComponent,
    PlaylistpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
