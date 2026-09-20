package DesignPatterns.SystemDesign.TicketBookingSystem;

import DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig.ISeatLockProvider;
import DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig.SeatLockProvider;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.MovieService;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.ShowService;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.TheatreService;

public class Main {

    public static void main(String[] args) {

        MovieService movieService = new MovieService();
        TheatreService theatreService = new TheatreService();
        ShowService showService = new ShowService();
        ISeatLockProvider iSeatLockProvider = new SeatLockProvider(600);

    }

}
