import { Component, OnInit } from '@angular/core';
import { Pet } from '../interfaces';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit {
  // declare this pet as partial, because we don't have the id just yet:
  pet!:Partial<Pet>;

  constructor() { }

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
    // Once we've changed up some data on our form, we can console log to display those changes:
    console.log(this.pet);
    // TODO: Send this to database
  }

}
