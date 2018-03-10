import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {GameService} from "../game/game.service";

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css'],
  providers: []
})
export class StatusComponent implements OnInit {

  @Input()
  public hostingTeam: string;

  @Input()
  public visitingTeam: string;

  constructor() { }

  ngOnInit() {
  }


}
