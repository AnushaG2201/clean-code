package com.thoughtworks.movierental;

public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double amount(){
        return movie.amountFor(daysRented);
    }

    int frequentRenterPoint() {
        return isBonusApplicable(daysRented) ? 2:1;

    }

    private boolean isBonusApplicable(int daysRented) {
        return movie.isNewRelease()
                &&
                (daysRented > 1);
    }

}