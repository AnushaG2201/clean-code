package com.thoughtworks.movierental;

class HtmlStatement {

    private String customerName;
    private Rentals rentals;


    public HtmlStatement(String name, Rentals rentals) {
        this.customerName = name;
        this.rentals = rentals;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "Rental Record for <b>" + customerName + "<b></br>";
    }

    private String htmlBody() {
        String result = "";
        for (Rental rental : rentals) {
            result += "&nbsp" + rental.getMovie().getTitle() + "&nbsp" +
                    rental.amount() + "</br>";
        }
        return result;
    }

    private String htmlFooter() {
        return "Amount owed is <b>" + rentals.totalAmount() + "<b></br>You earned <b>" + rentals.frequentRenterPoints()
                + "</b> frequent renter points";
    }
}
