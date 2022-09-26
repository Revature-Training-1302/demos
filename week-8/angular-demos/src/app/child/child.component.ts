import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  // instead of linking the template to another file, we can put the html code right inside the @Component decorator:
  template: `
    <p>Data from parent (displayed in child component): {{count}}</p>
    <button (click) = 'increment()'>+</button>
    <button (click) = 'decrement()'>-</button>
  `,
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  // We use the @Input decorator to specify that this value is going to be passed in when we instantiate the component
  @Input() public count: number = 0;

  // We use the EventEmitter object to emit some change in our data
  // in this case, we're going to increment or decrement our value:
  @Output()
  change: EventEmitter<number> =  new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
    this.increment();
  }

  increment() {
    this.count++;
    // emit the changed value to the parent:
    this.change.emit(this.count);
    console.log("Incrementing count from child component");
  }

  decrement() {
    this.count --;
    // emit the changed value back to the parent:
    this.change.emit(this.count);
    console.log("Decrementing count from child");
  }

}
