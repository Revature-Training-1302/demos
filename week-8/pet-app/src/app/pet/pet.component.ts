import { Component, OnInit } from '@angular/core';
// import the Pet interface:
import {Pet} from '../interfaces';
import { PetService } from '../services/pet.service';


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
  constructor(private petService: PetService) {
    
   }

  // Lifecycle method, in this case, the OnInit will run when the component is first initialized or rendered:
  ngOnInit(): void {
    // We can set up any variables or fields here:
    // because the pet is a field of this class, we use the "this" keyword
    let petId:Number = 4;
    // returns an observable, so we have to subscribe to the return value
    this.petService.getById(petId).subscribe (
      // take in an arrow function with the returned value as the parameter
      returnPet => {
        // update our pet field with the returned value from the service
        this.pet = returnPet;
      }
    )
    
  }

  hello() {
    alert("Hello!");
  }

  update() {
    this.petService.updatePet(this.pet).subscribe(
      returnPet => {
        console.log(returnPet);
      }
    )
  }

  delete() {
    this.petService.deletePet(this.pet.id).subscribe(
      deleted => {
        if(deleted) alert("Pet deleted!");
        else alert("Pet not deleted!");
      }
    )
  }

}