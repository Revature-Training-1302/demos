import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Person} from '../interfaces';
import { PersonService } from '../services/person.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  person! : Person

  constructor(private personService:PersonService,
    private router:Router) { }

  ngOnInit(): void {
    // filling out default values for this person (they will fill them in with the form)
    this.person = {
      name: "",
      password: "",
      pets: []
    }
  }

  login() {
    this.personService.login(this.person).subscribe(
      returnedPerson => {
        if(returnedPerson == null) {
          alert('Username or password is incorrect!');
        }
        else {
          alert('Login successful!');
          this.router.navigate(["/pets"]);
        }
      }
    )
  }

}
