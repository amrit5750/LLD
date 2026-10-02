package DesignPatterns.SystemDesign.TicketBookingSystem.Services;

import java.util.ArrayList;
import java.util.List;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;
import DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig.ISeatLockProvider;

public class SeatAvailabilityService {

    private final BookingService bookingService;
    private final ISeatLockProvider seatLockProvider;

    public SeatAvailabilityService(BookingService bookingService, ISeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(final Show show) {

        final List<Seat> allSeats = show.getScreen().getSeats();

        final List<Seat> unavailableSeats = getUnAvailableSeats(show);
        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }

    public List<Seat> getUnAvailableSeats(final Show show) {

        final List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }

}
