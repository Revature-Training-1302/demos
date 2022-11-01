import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {
  // What does Date.now() do?
  // shows the current date, month day, year....
  today: number = Date.now();
  name:string = "Harry Potter and the Order of the Phoenix";
  amount:number = 102310.3224365432 ;
  percentage:number = 0.45;

  constructor() { }

  ngOnInit(): void {
  }

}
