package DesignPatterns.ConcurrencyProblems.BookingSystem.Repository;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;

public interface BookingRepository {

    Booking findBookingbyID(String bookingID);

    void save(Booking booking);

}
