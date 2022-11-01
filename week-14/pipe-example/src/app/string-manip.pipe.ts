import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'stringManip'
})
export class StringManipPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): string {
    switch(args[0]) {
      case 'reverse':
        // reverse the string by converting to an array and then revert back to string:
        return value.split("").reverse().toString();
      case 'encrypt':
        let s = '';
        for(let i = 0; i < value.length; i ++) {
          // ex: a -> b
          // ex: y -> z
          // take the char code, add 1 and then convert back to string
          s += String.fromCharCode(value.charCodeAt(i) + 1);
        }
        return s;
      default:
        return value;
    }
  }

}
