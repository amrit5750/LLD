package DesignPatterns.SystemDesign.TicketBookingSystem.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Screen;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Theatre;
import DesignPatterns.SystemDesign.TicketBookingSystem.enums.SeatCategory;

public class TheatreService {

    private final Map<Integer, Theatre> threatres;
    private final Map<Integer, Screen> screens;
    private final Map<Integer, Seat> seats;

    private final AtomicInteger theatreCounter;
    private final AtomicInteger ScreenCounter;
    private final AtomicInteger seatsCounter;

    public TheatreService() {
        this.threatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();

        this.theatreCounter = new AtomicInteger(0);
        this.ScreenCounter = new AtomicInteger(0);
        this.seatsCounter = new AtomicInteger(0);
    }

    public Theatre getTheatre(final int theatreId) throws Exception {

        if (!threatres.containsKey(theatreId)) {
            throw new Exception("cannot find theatre with theatre id :" + theatreId);

        }
        return threatres.get(theatreId);

    }

    public Screen getScreen(final int screenId) throws Exception {
        if (!screens.containsKey(screenId)) {
            throw new Exception("cannot find screen with screen id :" + screenId);

        }
        return screens.get(screenId);

    }

    public Seat getSeat(final int seatId) throws Exception {
        if (!seats.containsKey(seatId)) {
            throw new Exception("cannot find seat with seatId id :" + seatId);

        }
        return seats.get(seatId);

    }

    public Theatre creaTheatre(final String theatreName) {
        int threatreId = theatreCounter.getAndIncrement();
        Theatre theatre = new Theatre(threatreId, theatreName);
        threatres.put(threatreId, theatre);
        return theatre;
    }

    public Screen createScreen(final String screenName, final Theatre theatre) {
        int screenId = seatsCounter.getAndIncrement();
        Screen screen = new Screen(screenId, screenName, theatre);
        screens.put(screenId, screen);
        return screen;
    }

    public Screen createScreenInTheatre(final String screenName, final Theatre theatre) {
        Screen screen = createScreen(screenName, theatre);
        theatre.addScreen(screen);
        return screen;

    }

    public Seat createSeatInScreen(final int rowNo, SeatCategory category, final Screen screen) {
        int seatId = seatsCounter.getAndIncrement();
        Seat seat = new Seat(seatId, rowNo, category);
        seats.put(seatId, seat);
        screen.addSeat(seat);
        return seat;
    }

}
