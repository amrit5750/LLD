package DesignPatterns.SystemDesign.TicketBookingSystem.Entities;

import java.util.List;

import DesignPatterns.SystemDesign.TicketBookingSystem.enums.BookingStatus;

public class Booking {

    private final int id;
    private final Show show;
    private final List<Seat> seatsBooked;
    private final User user;
    private BookingStatus bookingStatus;

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmedBooking() throws Exception {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new Exception("cannot confirm booking as is not in a stage of Create Booking Stage");
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() throws Exception {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new Exception("cannot expire booking as is not in a stage of Create Booking Stage");
        }
        this.bookingStatus = BookingStatus.EXPIRED;

    }

    public int getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public User getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Booking(int id, Show show, List<Seat> seatsBooked, User user) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED;
        ;
    }

}
