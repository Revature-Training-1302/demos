import { Component, OnInit } from '@angular/core';

interface Dinosaur  {
  name: String,
  habitat: String,
  diet: String,
  legs: Number
}

@Component({
  selector: 'app-dinos',
  templateUrl: './dinos.component.html',
  styleUrls: ['./dinos.component.css']
})
export class DinosComponent implements OnInit {
  // set up the data in our ts file
  dinosaur!: Dinosaur;

  constructor() { }

  ngOnInit(): void {
    this.dinosaur = {
      name: "T-Rex",
      habitat: "valley",
      diet: "carnivore",
      legs: 2
    }
  }

  print() {
    // here is where we put our logic of what we want
    //to do with the data:
    console.log(this.dinosaur);
  }

}
