import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-attribute-directives',
  templateUrl: './attribute-directives.component.html',
  styleUrls: ['./attribute-directives.component.css']
})
export class AttributeDirectivesComponent implements OnInit {
  isSpecial:boolean = false;
  // declare an image style as a variable:
  imgStyle!:Record<string, string>;

  name:string = "hello";
  constructor() { }

  ngOnInit(): void {
    // give the styling in our TS code
    this.imgStyle = {
      "width": "500px"
    }
  }

  change():void {
    this.isSpecial = !this.isSpecial;
    this.imgStyle = {
      "width" : "300px"
    }
  }

}
