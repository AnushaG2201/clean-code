package com.thoughtworks.movierental;

class TextStatement {

    private String customerName;
    private Rentals rentals;

    public TextStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + rentals.totalAmount() + "\n";
        result += "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
        return result;
    }
}
