package DesignPatterns.ConcurrencyProblems.BookingSystem.Service;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;

public class RefundService {

    public double calculateRefund(Booking booking, double penality) {
        return booking.getTotalAmount() - penality;
    }

}
