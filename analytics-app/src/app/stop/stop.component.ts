import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {GameService} from "../game/game.service";
import {Teams} from "../game/Teams";

@Component({
  selector: 'app-stop',
  templateUrl: './stop.component.html',
  styleUrls: ['./stop.component.css'],
  providers: [GameService]
})
export class StopComponent implements OnInit {

  public stateMessage = "";
  public stateCode = 0;

  @Output() teamsForGame: EventEmitter<Teams> = new EventEmitter<Teams>();

  constructor(private gameService: GameService) { }

  ngOnInit() {
  }

  stopGame() {
    this.gameService.stopGame().subscribe( answer => {
      this.stateMessage = answer.message;
      this.stateCode = answer.code;
    });
  }

}
