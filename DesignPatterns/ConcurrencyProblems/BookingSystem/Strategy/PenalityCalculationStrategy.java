package DesignPatterns.ConcurrencyProblems.BookingSystem.Strategy;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;

public interface PenalityCalculationStrategy {
    boolean supports(Booking booking);

    double calculatePenality(Booking booking);

}
