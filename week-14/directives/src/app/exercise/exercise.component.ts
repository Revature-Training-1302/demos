import { Component, OnInit } from '@angular/core';
import { Superhero } from '../interfaces';

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css']
})
export class ExerciseComponent implements OnInit {
  superheroes!: Superhero[];

  constructor() { }

  ngOnInit(): void {
    this.initHeroes();
  }

  initHeroes():void {
    this.superheroes = [
      {name:"Spider-Man", realName: "Peter Parker", power: "Web"},
      {name:"Iron-Man", realName: "Tony Stark", power: "Suit"},
      {name:"Captain Marvel", realName: "Carol Danvers", power: "Powers"},
      {name:"Black Panther", realName: "T'Challa", power: "Vibranium Suit"},
      {name:"Black Widow", realName: "Natasha Romanoff"},
      {name:"Batman", realName: "Bruce Wayne"},
      {name:"Wonder Woman", realName: "Diana Prince", power: "Lasso"},
      {name:"Super-Man", realName: "Clark Kent", power: "Flight"},
    ]
  }

}
