import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {StartComponent} from "./start/start.component";
import {HttpClientModule} from "@angular/common/http";
import {StatusComponent} from "./status/status.component";


@NgModule({
  declarations: [
    AppComponent,
    StartComponent,
    StatusComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
