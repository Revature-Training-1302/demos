import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-one-way',
  templateUrl: './one-way.component.html',
  styleUrls: ['./one-way.component.css']
})
export class OneWayComponent implements OnInit {
  // We create this string and use string interpolation to display it on the page
  name:string = "Bob";
  // use 2-way binding to map this value to input
  value:string = "";
  // use property binding to bind this url to the src property of our img tag:
  img:string = "https://www.history.com/.image/t_share/MTY3NDg4OTU3NjQxMTQwMDEz/halloween-gettyimages-172988453.jpg";
  // boolean to keep track of whether we show something:
  show:boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  // take in a message and alert that to the web page:
  alert_hello(message:string) {
    alert(`Hello, this alert is triggered, message : ${this.value}`);
  }

  // change the "show" variable from true to false or vice versa:
  toggle_show() {
    this.show = !this.show;
  }

}
