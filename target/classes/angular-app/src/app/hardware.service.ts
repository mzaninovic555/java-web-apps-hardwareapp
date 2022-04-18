import {Injectable} from '@angular/core';
import {catchError, Observable, of, tap} from 'rxjs';
import {Hardware} from './hardware';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HardwareService {

  private hardwareURL = "http://localhost:8080/hardware";

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  getHardwares(): Observable<Hardware[]> {
    return this.http.get<Hardware[]>(this.hardwareURL)
      .pipe(
        tap(_ => console.log("Fetched hardware")),
        catchError(this.handleError<Hardware[]>('getHardware', []))
      );
  }

  getHardwareByCode(code: string): Observable<Hardware> {
    return this.http.get<Hardware>(this.hardwareURL + `/${code}`)
      .pipe(
        tap(_ => console.log("Fetched hardware with code = " + code)),
        catchError(this.handleError<Hardware>('getHardwareByCode'))
      );
  }

  addHardware(hardware: Hardware): Observable<Hardware> {
    return this.http.post<Hardware>(this.hardwareURL, hardware, this.httpOptions)
      .pipe(
        tap((newHardware: Hardware) => console.log(`Added hardware w/ code=${newHardware.code}`)),
        catchError(this.handleError<Hardware>('addHardware'))
      );
  }

  deleteHardware(hardware: Hardware | string): Observable<Hardware> {
    console.log(hardware)
    const code = typeof hardware === 'string' ? hardware : hardware.code;
    const url = `${this.hardwareURL}/${code}`;

    console.log(url)

    return this.http.delete<Hardware>(url).pipe(
      tap(_ => console.log(`Deleted hardware with code = ${code}`)),
      catchError(this.handleError<Hardware>('deleteStudent'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    }
  }
}
