import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { mergeMap, Observable } from 'rxjs';
import {url} from '../endpoint';

import {Person} from '../interfaces';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http:HttpClient) { }

  login(person:Person):Observable<Person> {
    return this.http.post<Person>(`${url}/people?auth=login`, person);
  }

  register(person:Person):Observable<Person> {
    return this.http.post<Person>(`${url}/people?auth=register`, person);
    // .pipe(
    //   mergeMap
    // )
  }
}
