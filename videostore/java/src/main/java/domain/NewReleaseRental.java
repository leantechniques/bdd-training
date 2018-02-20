package domain;

public class NewReleaseRental extends Rental {
	public NewReleaseRental(Movie movie, int daysRented) {
		super(movie, daysRented);
	}

	@Override
	double calculatePrice() {
		return (double) (getDaysRented() * 3);
    }

	@Override
	public int calculatePoints() {
        int points = 1;
        if (getDaysRented() > 1)
            points++;
        return points;
    }
}
