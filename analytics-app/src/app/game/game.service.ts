import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {CustomResponse} from "./CustomResponse";


@Injectable()
export class GameService {

  constructor(private http: HttpClient) {
  }


  startGame() : Observable<CustomResponse> {
    return this.http.get<CustomResponse>('//localhost:8080/start-game');
  }

  stopGame() : Observable<CustomResponse> {
    return this.http.get<CustomResponse>('//localhost:8080/end-game');
  }

}
