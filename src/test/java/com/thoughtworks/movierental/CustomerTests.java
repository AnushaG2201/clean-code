package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void shouldReturnCustomerStatementForRegularMovie() {

        Movie movie = new Movie("ABC", 0);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("Anusha");
        customer.addRental(rental);

        String result = customer.statement();

        String expected = "Rental Record for Anusha\n" +
                "\tABC\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnCustomerStatementForNewRelease() {
        Movie movie = new Movie("ABC", 1);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("Anusha");
        customer.addRental(rental);

        String result = customer.statement();

        String expected = "Rental Record for Anusha\n" +
                "\tABC\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, result);

    }

    @Test
    public void shouldGenerateStatement() {
        Customer customer = new Customer("John Doe");

        customer.addRental(new Rental(new Movie("Jumanji", Movie.CHILDREN), 2));
        customer.addRental(new Rental(new Movie("3 idiots", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Avengers", Movie.NEW_RELEASE), 15));

        String statement = customer.statement();

        assertEquals("Rental Record for John Doe\n" +
                "\tJumanji\t1.5\n" +
                "\t3 idiots\t5.0\n" +
                "\tAvengers\t45.0\n" +
                "Amount owed is 51.5\n" +
                "You earned 4 frequent renter points", statement);
    }

    @Test
    void shouldReturnHtmlStatement() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Jumanji", Movie.CHILDREN), 2));
        customer.addRental(new Rental(new Movie("3 idiots", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Avengers", Movie.NEW_RELEASE), 15));

        String htmlStatement = customer.htmlStatement();

        assertEquals("Rental Record for <b>John Doe<b></br>&nbspJumanji&nbsp1.5</br>&nbsp3 idiots&nbsp5.0</br>&nbspAvengers&nbsp45.0"+
                "</br>Amount owed is <b>51.5<b></br>You earned <b>4</b> frequent renter points", htmlStatement);


    }


}