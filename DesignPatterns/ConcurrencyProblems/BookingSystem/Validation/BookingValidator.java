package DesignPatterns.ConcurrencyProblems.BookingSystem.Validation;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;
import DesignPatterns.ConcurrencyProblems.BookingSystem.enums.BookingStatus;

public class BookingValidator {

    public boolean validate(Booking booking) throws Exception {

        if (booking == null)
            return false;

        if (booking.getStatus() == BookingStatus.CANCELLED) {
            return false;
        }
        return true;

    }

}
