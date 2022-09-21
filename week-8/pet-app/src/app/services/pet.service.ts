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

  // simulating an http response by manually constucting an observable:
  getAllPets(): Observable<Pet[]> {
    // dummy data, will be replaced with http request:
    let pets:Pet[] = [
      {
        id: 1,
        name: "Garfield",
        species: "cat",
        food: "lasagna"
      },
      {
        id: 2,
        name: "Scooby Doo",
        species: "dog",
        food: "Scooby Snacks"
      },
      {
        id: 3,
        name: "Clifford",
        species: "dog",
        food: "kibble"
      },
    ]
    return of(pets);
  }

  getById(id_ :Number): Observable<Pet> {
    // dummy data, will be replaced with http request:
    let pet:Pet = {
      id: id_,
      name: "Dummy pet",
      species: "cat",
      food: "food"
    };
    return of(pet);
  }

  updatePet(pet: Pet): Observable<Pet> {
    return of(pet);
  }

  deletePet(id:Number): Observable<boolean> {
    // just return a boolean that indicates whether the deletion was successful:
    return of(true);
  }


}
