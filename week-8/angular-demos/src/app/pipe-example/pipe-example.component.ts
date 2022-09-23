import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe-example',
  templateUrl: './pipe-example.component.html',
  styleUrls: ['./pipe-example.component.css']
})
export class PipeExampleComponent implements OnInit {
  title:any = "Harry Potter";

  date = new Date(2022 ,9, 22);

  sentence = "This sentence has 5 words.";

  constructor() { }

  ngOnInit(): void {
  }

}
