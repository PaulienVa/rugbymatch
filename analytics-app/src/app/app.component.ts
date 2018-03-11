import { Component } from '@angular/core';
import {Teams} from "./game/Teams";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public teams: Teams;

  gameStartedHandler(teams: Teams){
    this.teams = teams;
  }
}
