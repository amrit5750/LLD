package DesignPatterns.ConcurrencyProblems.BookingSystem.Strategy;

import java.time.Duration;
import java.time.LocalDateTime;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;

public class BeforeOneWeekStrategy implements PenalityCalculationStrategy {

    @Override
    public boolean supports(Booking booking) {
        return Duration.between(booking.getBookingTime(), LocalDateTime.now()).toDays() > 7;
    }

    @Override
    public double calculatePenality(Booking booking) {
        return booking.getTotalAmount() * 0.30;

    }

}
