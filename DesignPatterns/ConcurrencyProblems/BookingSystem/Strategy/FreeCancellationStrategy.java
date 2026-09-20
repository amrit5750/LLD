package DesignPatterns.ConcurrencyProblems.BookingSystem.Strategy;

import java.time.Duration;
import java.time.LocalDateTime;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;

public class FreeCancellationStrategy implements PenalityCalculationStrategy {

    @Override
    public boolean supports(Booking booking) {
        return Duration.between(booking.getBookingTime(), LocalDateTime.now()).toHours() <= 24;
    }

    @Override
    public double calculatePenality(Booking booking) {
        return 0;
    }

}
