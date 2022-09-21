import { Component, OnInit } from '@angular/core';
import { Pet } from '../interfaces';
import { PetService } from '../services/pet.service';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit {
  // declare this pet as partial, because we don't have the id just yet:
  pet!:Partial<Pet>;

  // dependency injection, put the service in the constructor:
  constructor(private petService:PetService ) { }

  ngOnInit(): void {
    // 2 way binding, making sure that this values are displayed on some form on our web page
    // and changes to that form will affect the data here
    this.pet = {
      // because when we're adding a pet, we don't know the id, so we can't provide it here
      name: "default name",
      species: "default species",
      food: "default food"
    }
  }

  add(): void{
    if(this.validatePet()) {
      // Once we've changed up some data on our form, we can console log to display those changes:
      this.petService.addPet(this.pet).subscribe(
        pet => {
          // taking the returned id value and setting it to the pet
          this.pet.id = pet.id;
          // alert the user what the generated id is:
          alert(`Pet added successfully, generated id is : ${pet.id}`);
        }
      )
    }
    else {
      alert("One or more fields is not valid!");
    }
    // TODO: Send this to database
  }

  // custom validate function:
  validatePet() {
    if(this.pet.name?.trim() == "") return false;
    if(this.pet.species == "") return false;
    if(this.pet.food == "") return false;
    // if all of the fields are not empty, we can return true:
    return true;
  }

  // TODO, validate the data before we send it:

}
