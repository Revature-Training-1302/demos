import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  // the name of the pipe, what we type out to use this pipe to transform some data
  name: 'negate'
})
export class NegatePipe implements PipeTransform {

  // this transform function represents the behavior of our pipe
  transform(value: number, ...args: unknown[]):number {
    return -1* value;
  }

}
