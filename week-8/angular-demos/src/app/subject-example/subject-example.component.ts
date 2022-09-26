import { Component, OnInit } from '@angular/core';
import { Subject, BehaviorSubject, ReplaySubject, AsyncSubject } from 'rxjs';

@Component({
  selector: 'app-subject-example',
  templateUrl: './subject-example.component.html',
  styleUrls: ['./subject-example.component.css']
})
export class SubjectExampleComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.async_subject();
  }

  subject_ex() {
    // create our subject
    const subject = new Subject();

    // once we set up the first observer, they're going to get all future values:
    subject.subscribe({
      // this will be called whenever our first observer gets a value:
      next: (data) => console.log('First observer: ' + data)
    })

    subject.next(1);
    subject.next(2);
    subject.next(3);

    // another subscrube method call, the second observer:
    // this second observer will only get values that are returned after its creation
    subject.subscribe({
      next: (data) => console.log('Second observer: ' + data)
    })

    subject.next(4);
    subject.next(5);
    subject.next(6);
  }

  behavior_subject() {
    // note that we are declaring a Behavior Subject instead of a regular Subject
    // can declare a starting value 0
    const subject = new BehaviorSubject(0);
   //First Observer
   subject.subscribe({
      next: (data) => console.log('First observer prints '+ data)
   });
   subject.next(1);
   // temporarily store this value, so it will be consumed by the next observer:
   subject.next(2);
   //Second Observer, will have access to 2222 because it was stored
   subject.subscribe({
      next: (data) => console.log('Second observer prints '+ data)
   });
   subject.next(3);
  }

  replay_subject() {
    // each observer emits 2 values from the last observer:
    const subject = new ReplaySubject(2);
   //First Observer
   subject.subscribe({
      next: (data) => {
         return console.log('First observer prints ' + data);
      }
   });
   subject.next(1);
   subject.next(2);
   //Second Observer, should have access to 1 and 2 because we're using a ReplaySubject with 2
   subject.subscribe({
      next: (data) => {
         return console.log('Second observer prints ' + data);
      }
   });
   subject.next(3);
  }

  async_subject() {
    const subject = new AsyncSubject();
   //First Observer
   subject.subscribe({
      next: (data) => console.log('First observer prints '+ data)
   });
   subject.next(1);
  //  subject.complete();
   subject.next(2);
  //  subject.complete();
   //Second Observer
   subject.subscribe({
      next: (data) => console.log('Second observer prints '+ data)
   });
   subject.next(3);
   // without this, no values emitted:
   subject.complete();
  }

}
