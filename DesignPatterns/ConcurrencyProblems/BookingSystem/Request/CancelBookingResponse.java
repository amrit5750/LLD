package DesignPatterns.ConcurrencyProblems.BookingSystem.Request;

import DesignPatterns.ConcurrencyProblems.BookingSystem.enums.BookingStatus;

public class CancelBookingResponse {

    private String bookingID;
    private double penality;
    private double refund;
    private BookingStatus status;

    public CancelBookingResponse(String bookingID, double penality, double refund, BookingStatus status) {
        this.bookingID = bookingID;
        this.penality = penality;
        this.refund = refund;
        this.status = status;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public double getPenality() {
        return penality;
    }

    public void setPenality(double penality) {
        this.penality = penality;
    }

    public double getRefund() {
        return refund;
    }

    public void setRefund(double refund) {
        this.refund = refund;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

}
