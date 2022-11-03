import { Component, OnInit } from '@angular/core';

// define the selector to be d-comp (dynamic component)
@Component({
  selector: 'd-comp',
  // <d-comp></d-comp>
  template: '<span>I am the dynamic component</span>',
  styleUrls: ['./component-dynamic.component.css']
})
export class ComponentDynamic implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
