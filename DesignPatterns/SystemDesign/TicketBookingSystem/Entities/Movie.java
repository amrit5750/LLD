package DesignPatterns.SystemDesign.TicketBookingSystem.Entities;

public class Movie {

    private final int movieId;
    private final String movieName;
    private final int movieDurationMintutes;

    public Movie(int movieId, String movieName, int movieDurationMintutes) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDurationMintutes = movieDurationMintutes;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieDurationMintutes() {
        return movieDurationMintutes;
    }

}
