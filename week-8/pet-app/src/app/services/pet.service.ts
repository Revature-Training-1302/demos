import { Injectable } from '@angular/core';
import {Pet} from '../interfaces';
import { Observable, of } from 'rxjs';

// Injectable lets us use inject this as a dependency:
@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor() { }

  // take in a pet with no id, return an obserable of a pet with the id
  addPet(pet:Partial<Pet>): Observable<Partial<Pet>>{
    // set a dummy id:
    pet.id = 4;
    // TODO, send this to the database:
    // return an observable of our pet object, simulating what we would get from an HTTP response:
    return of(pet);
  }
}
