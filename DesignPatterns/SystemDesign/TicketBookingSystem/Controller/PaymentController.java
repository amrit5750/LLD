package DesignPatterns.SystemDesign.TicketBookingSystem.Controller;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.User;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.PaymentService;

public class PaymentController {

    public final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processPayment(final String bookingId, final User user) throws Exception {
        paymentService.processPayment(bookingId, user);

    }

}
