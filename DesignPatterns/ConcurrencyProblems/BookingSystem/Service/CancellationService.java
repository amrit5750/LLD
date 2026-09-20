package DesignPatterns.ConcurrencyProblems.BookingSystem.Service;

import DesignPatterns.ConcurrencyProblems.BookingSystem.Entity.Booking;
import DesignPatterns.ConcurrencyProblems.BookingSystem.Repository.BookingRepository;
import DesignPatterns.ConcurrencyProblems.BookingSystem.Strategy.PenalityCalculationStrategy;
import DesignPatterns.ConcurrencyProblems.BookingSystem.Validation.BookingValidator;
import DesignPatterns.ConcurrencyProblems.BookingSystem.config.Factory.PenalityStrategyFactory;
import DesignPatterns.ConcurrencyProblems.BookingSystem.enums.BookingStatus;
import DesignPatterns.ConcurrencyProblems.BookingSystem.Request.CancelBookingResponse;
import DesignPatterns.ConcurrencyProblems.BookingSystem.Request.CancelBookingRequest;

class CancellationService {

    private BookingRepository repository;
    private PenalityStrategyFactory factory;

    private RefundService refundService;

    public CancelBookingResponse cancel(
            CancelBookingRequest request) throws Exception {

        Booking booking = repository.findBookingbyID(
                request.getBookingID());

        BookingValidator bookingValidator = new BookingValidator();
        double penalty = 0;
        double refund = 0;

        if (bookingValidator.validate(booking)) {
            PenalityCalculationStrategy strategy = factory.getStrategy(booking);

            penalty = strategy.calculatePenality(booking);

            refund = refundService.calculateRefund(
                    booking,
                    penalty);

            booking.setStatus(BookingStatus.CANCELLED);

            repository.save(booking);

        }

        return new CancelBookingResponse(
                booking.getBookingID(),
                penalty,
                refund,
                BookingStatus.CANCELLED);

    }

}
