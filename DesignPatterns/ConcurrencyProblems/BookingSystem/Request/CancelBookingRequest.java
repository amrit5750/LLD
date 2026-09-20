package DesignPatterns.ConcurrencyProblems.BookingSystem.Request;

public class CancelBookingRequest {

    private String bookingID;
    private String cancelledBy;

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

}
