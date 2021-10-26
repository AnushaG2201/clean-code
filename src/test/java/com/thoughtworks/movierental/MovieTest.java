package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    void shouldReturnAmountForBlueRayMovies() {
        Movie movie = new Movie("ABC", 3);

        double actualAmount = movie.amountFor(2);

        assertEquals(0,actualAmount);
    }
}
