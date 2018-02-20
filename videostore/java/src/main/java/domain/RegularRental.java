package domain;

public class RegularRental extends Rental {
    public RegularRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double calculatePrice() {
        double price = 2;
        if (getDaysRented() > 2)
            price += (getDaysRented() - 2) * 1.5;
        return price;
    }

    @Override
    public int calculatePoints() {
        return 1;
    }
}
