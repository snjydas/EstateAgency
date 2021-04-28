import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'availableProp',
})
export class AvailablePropPipe implements PipeTransform {
  transform(value: any[]): any[] {
    return value.filter((data) => data.status == true);
  }
}
