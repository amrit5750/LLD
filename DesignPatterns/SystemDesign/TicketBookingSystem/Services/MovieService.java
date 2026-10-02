package DesignPatterns.SystemDesign.TicketBookingSystem.Services;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Movie;

public class MovieService {

    private final Map<Integer, Movie> movies;
    private final AtomicInteger movieCounter;

    public MovieService(Map<Integer, Movie> movies, AtomicInteger movieCounter) {
        this.movies = movies;
        this.movieCounter = movieCounter;
    }

    public Movie getMovie(final int movieId) throws Exception {

        if (!movies.containsKey(movieId)) {
            throw new Exception("No Movie Found with MovieId " + movieId);
        }
        return movies.get(movieId);

    }

    public Movie createMovie(final String movieName, final int durationInMinutes) {
        int movieId = movieCounter.incrementAndGet();
        Movie movie = new Movie(movieId, movieName, durationInMinutes);
        movies.put(movieId, movie);
        return movie;
    }

}
