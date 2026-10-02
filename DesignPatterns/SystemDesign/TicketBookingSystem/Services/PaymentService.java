package DesignPatterns.SystemDesign.TicketBookingSystem.Services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Booking;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.User;
import DesignPatterns.SystemDesign.TicketBookingSystem.Payment.PaymentStrategy;

public class PaymentService {
    Map<Booking, Integer> bookingFailures;
    private final PaymentStrategy paymentStrategy;
    private BookingService bookingService;

    public PaymentService(PaymentStrategy paymentStrategy, BookingService bookingService) {
        this.bookingFailures = new ConcurrentHashMap<>();
        this.paymentStrategy = paymentStrategy;
        this.bookingService = bookingService;

    }

    public void processPaymentFailed(final String bookingId, final User user) throws Exception {

        Booking booking = bookingService.getBooking(bookingId);
        if (!booking.getUser().equals(user)) {
            throw new Exception("Only the booking owner can report the payment failure");

        }

        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking, 0);
        }

        final Integer currentFailuresCount = bookingFailures.get(booking);
        final Integer newFailureCount = currentFailuresCount + 1;
        bookingFailures.put(booking, newFailureCount);
        System.out.println("Could not process the payment for booking with Id " + bookingId);

    }

    public void processPayment(final String bookingId, final User user) throws Exception {
        if (paymentStrategy.processPayment()) {
            bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
        } else {
            processPaymentFailed(bookingId, user);
        }

    }

}
