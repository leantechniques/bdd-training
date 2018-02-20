package domain;

public class ChildrensRental extends Rental {
    public ChildrensRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double calculatePrice() {
        double price = 1.5;
        if (getDaysRented() > 3)
            price += (getDaysRented() - 3) * 1.5;
        return price;
    }

    @Override
    public int calculatePoints() {
        return 1;
    }
}
