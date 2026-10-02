package DesignPatterns.SystemDesign.TicketBookingSystem.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Booking;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.User;
import DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig.ISeatLockProvider;

public class BookingService {

    private final Map<String, Booking> showBookings;
    private final ISeatLockProvider iSeatLockProvider;
    private final AtomicInteger bookingIdCounter = new AtomicInteger(0);

    public BookingService(Map<String, Booking> showBookings, ISeatLockProvider iSeatLockProvider) {
        this.showBookings = new ConcurrentHashMap<>();
        this.iSeatLockProvider = iSeatLockProvider;
    }

    public Booking getBooking(final String bookingId) throws Exception {

        if (showBookings.containsKey(bookingId)) {
            throw new Exception("No Booking exists for the ID : "
                    + bookingId);

        }
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(final Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : showBookings.values()) {
            if (booking.getShow().equals(show)) {
                response.add(booking);
            }

        }
        return response;
    }

    public Booking createBooking(final User user, final Show show, final List<Seat> seats) throws Exception {

        if (isAnySeatAlreadyBooked(show, seats)) {
            throw new Exception("Seat is Already Booked");
        }

        iSeatLockProvider.lockSeats(show, seats, user);

        final String bookingId = String.valueOf(bookingIdCounter.getAndIncrement());
        final Booking newBooking = new Booking(0, show, seats, user);
        showBookings.put(bookingId, newBooking);
        return newBooking;
    }

    private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return true;
            }

        }
        return false;
    }

    public List<Seat> getBookedSeats(final Show show) {
        return getAllBookings(show).stream().filter(Booking::isConfirmed).map(Booking::getSeatsBooked)
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    public void confirmBooking(final Booking booking, final User user) throws Exception {

        if (booking.getUser() != user) {
            throw new Exception("Cannot confirm a booking made by another user");
        }
        for (Seat seat : booking.getSeatsBooked()) {
            if (!iSeatLockProvider.validateLock(booking.getShow(), seat, user)) {
                throw new Exception("Acquired Lock is either invalid or has Expired");

            }

        }
        booking.confirmedBooking();

    }

}
