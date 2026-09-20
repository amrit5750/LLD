package DesignPatterns.ConcurrencyProblems.BookingSystem.config.Factory;

import java.util.List;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;
import DesignPatterns.ConcurrencyProblems.BookingSystem.Strategy.PenalityCalculationStrategy;

public class PenalityStrategyFactory {

    private List<PenalityCalculationStrategy> strategies;

    public PenalityStrategyFactory(List<PenalityCalculationStrategy> strategies) {
        this.strategies = strategies;
    }

    public PenalityCalculationStrategy getStrategy(Booking booking) {

        return strategies.stream().filter(s -> s.supports(booking)).findFirst().orElseThrow();
    }

}
