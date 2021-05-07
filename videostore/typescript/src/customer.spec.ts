import { Customer } from "./customer";
import { Movie } from "./movie";
import { Rental } from "./rental";

it("should return expected statement", () => {
  const customer = new Customer("Bob");
  customer.addRental(new Rental(new Movie("Pulp Fiction", Movie.REGULAR), 2));
  customer.addRental(new Rental(new Movie("Lilo & Stitch", Movie.CHILDREN), 4));
  customer.addRental(new Rental(new Movie("Moana", Movie.CHILDREN), 2));
  customer.addRental(new Rental(new Movie("Gladiator", Movie.REGULAR), 6));
  customer.addRental(new Rental(new Movie("Avengers", Movie.NEW_RELEASE), 4));

  var bobsStatement = customer.statement();

  const expectedStatement =
    "Rental Record for Bob\n" +
    "\tPulp Fiction\t2.0\n" +
    "\tLilo & Stitch\t3.0\n" +
    "\tMoana\t1.5\n" +
    "\tGladiator\t8.0\n" +
    "\tAvengers\t12.0\n" +
    "You owed 26.5\n" +
    "You earned 6 frequent renter points \n";

  expect(bobsStatement).toEqual(expectedStatement);
});
