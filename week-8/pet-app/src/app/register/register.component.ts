import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Person } from '../interfaces';
import { PersonService } from '../services/person.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  // declare the person object
  person!:Person;

  constructor(private personService:PersonService, private router:Router) { }

  ngOnInit(): void {
    this.person = {
      name: "",
      password: "",
      pets: []
    }
  }

  register() {
      this.personService.register(this.person).subscribe({
        // this is the function that will execute when we get the next value successfully
        next: (returnVal) => {alert(`Registration successful! Id is ${returnVal.id}`)
              this.router.navigate(["/pets"])},
        // this is the function that will execute upon failure:
        error: () => {alert("Registration unsuccessful!")}
      }
      );
    
  }

}
