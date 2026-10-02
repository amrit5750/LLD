package DesignPatterns.SystemDesign.TicketBookingSystem.Controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Movie;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Screen;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.MovieService;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.SeatAvailabilityService;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.ShowService;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.TheatreService;

public class ShowController {

    private final SeatAvailabilityService availabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public ShowController(SeatAvailabilityService availabilityService, ShowService showService,
            TheatreService theatreService, MovieService movieService) {

        this.availabilityService = availabilityService;
        this.showService = showService;
        this.theatreService = theatreService;
        this.movieService = movieService;
    }

    public int createShow(final int movieId, final int screenId, final Date startTime, final Integer durationInMinutes)
            throws Exception {

        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie, screen, startTime, durationInMinutes).getId();

    }

    public List<Integer> getAvailableSeats(final int showId) throws Exception {
        final Show show = showService.getShow(showId);
        final List<Seat> availableSeats = availabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getSeatID).collect(Collectors.toList());

    }

}
