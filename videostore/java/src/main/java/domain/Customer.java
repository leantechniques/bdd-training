package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    double totalAmount = 0;
    int frequentRenterPoints = 0;

    public String statement() {
        return getHeader() +
                getLines() +
                getFooter();
    }

    private String getHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private String getFooter() {
        return "You owed " + totalAmount +
                "\nYou earned " + frequentRenterPoints + " frequent renter points\n";
    }

    private String getLines() {
        String lines = "";
        for (Rental each : rentals) {
            lines += getLine(each);
        }
        return lines;
    }

    private String getLine(Rental each) {
        double thisAmount = each.calculatePrice();
        frequentRenterPoints += each.calculatePoints();
        totalAmount += thisAmount;
        return "\t" + each.getMovie().getTitle() + "\t"
                + thisAmount + "\n";
    }


}