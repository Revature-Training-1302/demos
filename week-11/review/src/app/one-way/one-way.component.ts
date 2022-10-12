import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-one-way',
  templateUrl: './one-way.component.html',
  styleUrls: ['./one-way.component.css']
})
export class OneWayComponent implements OnInit {
  // this value will be placed on the page with string interpolation:
  name:string = "Robert";
  img:string = "https://www.history.com/.image/t_share/MTY3NDg4OTU3NjQxMTQwMDEz/halloween-gettyimages-172988453.jpg";
  show:boolean = true;


  constructor() { }

  ngOnInit(): void {
  }

  alert_message() {
    alert("Hello!")
  }

  toggle_show() {
    this.show = !this.show;
  }

}
