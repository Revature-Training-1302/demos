import { Component, OnInit } from '@angular/core';
// import the Pet interface:
import {Pet} from '../interfaces';


// This decorator makes this class a component
@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {



  // when we declare variables in TypeScript, we need to give it a type
  // in this case, pet is an object, so we need to give it an interface:
  pet!: Pet;

  img_url:String = "https://www.aquariumofpacific.org/images/exhibits/Magnificent_Tree_Frog_900.jpg";

  // this boolean keeps track of whether we want to show the "extra" content on our page
  show_extra_content:boolean = false;

  // The only thing we want to use our constructor for is dependency injection:
  constructor() {
    
   }

  // Lifecycle method, in this case, the OnInit will run when the component is first initialized or rendered:
  ngOnInit(): void {
    // We can set up any variables or fields here:
    // because the pet is a field of this class, we use the "this" keyword
    this.pet = {
      id: -1,
      name: "garfield",
      species: "cat",
      food: "lasagna"
    }
  }

  hello() {
    alert("Hello!");
  }

}
