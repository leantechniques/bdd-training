import { MovieCode } from "./movie";
import { Rental } from "./rental";

export type Customer = {
  name: string;
};

export function createStatement(customer: Customer, rentals: Rental[]): string {
  let frequentRenterPoints = 0;
  let totalAmount = 0;
  let result = "Rental Record for " + customer.name + "\n";
  for (const each of rentals) {
    let thisAmount = 0;

    // determines the amount for each line
    switch (each.movie.code) {
      case MovieCode.Regular:
        thisAmount += 2;
        if (each.daysRented > 2) {
          thisAmount = thisAmount + (each.daysRented - 2) * 1.5;
        }
        break;
      case MovieCode.NewRelease:
        thisAmount = thisAmount + each.daysRented * 3;
        break;
      case MovieCode.Children:
        thisAmount += 1.5;
        if (each.daysRented > 3) {
          thisAmount = thisAmount + (each.daysRented - 3) * 1.5;
        }
        break;
    }

    frequentRenterPoints++;
    if (each.movie.code == MovieCode.NewRelease && each.daysRented > 1) {
      frequentRenterPoints++;
    }

    result += "\t" + each.movie.title + "\t" + thisAmount.toFixed(1) + "\n";
    totalAmount += thisAmount;
  }

  result += "You owed " + totalAmount.toFixed(1) + "\n";
  result += "You earned " + frequentRenterPoints + " frequent renter points \n";

  return result;
}
