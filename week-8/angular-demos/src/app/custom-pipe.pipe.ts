import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'wordCount'
})
export class CustomPipePipe implements PipeTransform {

  transform(value: String, ...args: unknown[]): unknown {
    // return the number of words:
    return value.trim().split(' ').length;
  }

}
