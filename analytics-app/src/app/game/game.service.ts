import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";


@Injectable()
export class GameService {

  constructor(private http: HttpClient) {
  }


  startGame() : Observable<Response> {
    return this.http.get<Response>('//localhost:8080/start-game');
  }
}
