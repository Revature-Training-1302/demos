import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  template: `
    <h2>Input example:</h2>
    <!-- From the parent component, pass in the number 9 as the input to the child component -->
    <app-child [count] = 'count' (change) = 'changeCount($event)'></app-child>
    <h1>Count from parent: {{count}}</h1>
  `,
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {
  count:number = 9;

  constructor() { }

  ngOnInit(): void {
  }

  // callback function that will update the parent's state based on some event
  changeCount(event:any) {
    this.count = event;
  }

}
