package DesignPatterns.SystemDesign.TicketBookingSystem.Controller;

import DesignPatterns.SystemDesign.TicketBookingSystem.Services.MovieService;

public class MovieController {

    private final MovieService movieService;

    public MovieController(final MovieService movieService) {
        this.movieService = movieService;

    }

    public int createMovie(final String movieName, final int durationInMinutues) {
        return movieService.createMovie(movieName, durationInMinutues).getMovieId();

    }

}
