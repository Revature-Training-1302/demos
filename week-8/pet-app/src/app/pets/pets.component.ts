import { Component, OnInit } from '@angular/core';
import { Pet } from '../interfaces';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {

  pets!: Pet[];

  constructor() { }

  ngOnInit(): void {
    // declare a dummy list of pets:
    // TODO: get this information from our back-end:
    this.pets = [{
      id: 1,
      name: "garfield",
      species: "cat",
      food: "lasagna"
    }, {
      id: 2,
      name: "ashes",
      species: "cat",
      food: "tuna"
    }, {
      id: 3,
      name: "scooby doo",
      species: "dog",
      food: "scooby snacks"
    }
    ]
  }

}
