import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'offer'
})
export class OfferPipe implements PipeTransform {

  transform(value: string): string {
    if (value == "Sell") {
      return "Buy";
    }
    else {
      return "Rent";
    }
  }

}
