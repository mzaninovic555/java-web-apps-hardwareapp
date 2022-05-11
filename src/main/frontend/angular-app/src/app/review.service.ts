import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of, tap } from 'rxjs';
import { Review } from './review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private reviewURL = "http://localhost:8080/review";

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getReviews(): Observable<Review[]> {
    return this.http.get<Review[]>(this.reviewURL)
      .pipe(
        tap(_ => console.log("Fetched hardware")),
        catchError(this.handleError<Review[]>('getHardware', []))
      );
  }

  getReviewById(id: number): Observable<Review> {
    return this.http.get<Review>(this.reviewURL + `/${id}`)
      .pipe(
        tap(_ => console.log("Fetched review with id = " + id)),
        catchError(this.handleError<Review>('getReviewByid'))
      );
  }

  getReviewsByHardwareCode(code: String): Observable<Review[]> {
    return this.http.get<Review[]>(this.reviewURL + `?code=${code}`)
      .pipe(
        tap(_ => console.log("Fetched review with code = " + code)),
        catchError(this.handleError<Review[]>('getReviewByCode'))
      );
  }

  getReviewsByContent(content: String): Observable<Review[]> {
    return this.http.get<Review[]>(this.reviewURL + `?content=${content}`)
      .pipe(
        tap(_ => console.log("Fetched review with content = " + content)),
        catchError(this.handleError<Review[]>('getReviewBycontent'))
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
