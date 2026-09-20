package DesignPatterns.SystemDesign.TicketBookingSystem.Entities;

import DesignPatterns.SystemDesign.TicketBookingSystem.enums.SeatCategory;

public class Seat {

    private final int seatID;
    private final int row;
    private final SeatCategory seatCategory;

    public Seat(int seatID, int row, SeatCategory seatCategory) {
        this.seatID = seatID;
        this.row = row;
        this.seatCategory = seatCategory;
    }

    public int getSeatID() {
        return seatID;
    }

    public int getRow() {
        return row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

}
