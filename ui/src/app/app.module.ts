import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MainPanelComponent } from './main-panel/main-panel.component';
import { BottomPanelComponent } from './bottom-panel/bottom-panel.component';
import { PicturePanelComponent } from './picture-panel/picture-panel.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    MainPanelComponent,
    BottomPanelComponent,
    PicturePanelComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
