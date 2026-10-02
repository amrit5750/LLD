package DesignPatterns.SystemDesign.TicketBookingSystem.Entities;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private final int screenId;
    private final String name;
    private final Theatre thratre;
    private List<Seat> seats;

    public Screen(int screenId, String name, Theatre thratre) {
        this.screenId = screenId;
        this.name = name;
        this.thratre = thratre;
        this.seats = new ArrayList<>();
    }

    public int getScreenId() {
        return screenId;
    }

    public String getName() {
        return name;
    }

    public Theatre getThratre() {
        return thratre;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(final Seat seat) {
        this.seats.add(seat);
    }

}
