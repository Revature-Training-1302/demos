import { Component, OnInit } from '@angular/core';
import { Person } from '../interfaces';

@Component({
  selector: 'app-structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css']
})
export class StructuralDirectivesComponent implements OnInit {
  person!:Person;
  foods: string[] = ["apple", "pizza", "bread", "spaghetti"];
  status: string = "yes";
  constructor() { }

  ngOnInit(): void {
    // this.initPerson();
  }

  initPerson ():void {
    this.person = {
      name: "Harry",
      age: 20
    }
  }

}
