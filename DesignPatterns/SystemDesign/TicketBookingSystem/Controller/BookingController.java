package DesignPatterns.SystemDesign.TicketBookingSystem.Controller;

import java.util.ArrayList;
import java.util.List;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.User;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.BookingService;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.ShowService;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.TheatreService;

public class BookingController {

    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    public BookingController(final ShowService showService, final BookingService bookingService,
            TheatreService theatreService) {
        this.showService = showService;
        this.bookingService = bookingService;
        this.theatreService = theatreService;
    }

    public String createBooking(final User user, final int showId, final List<Integer> seatsIds)
            throws Exception {

        final Show show = showService.getShow(showId);

        final List<Seat> seats = new ArrayList<>();

        for (Integer seatId : seatsIds) {
            Seat seat = theatreService.getSeat(seatId);
            seats.add(seat);

        }
        return String.valueOf(bookingService.createBooking(user, show, seats).getId());

    }

}
