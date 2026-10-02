package DesignPatterns.SystemDesign.TicketBookingSystem.Controller;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Screen;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Theatre;
import DesignPatterns.SystemDesign.TicketBookingSystem.Services.TheatreService;
import DesignPatterns.SystemDesign.TicketBookingSystem.enums.SeatCategory;

public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(final TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public int createTheatre(final String theatreName) {
        return theatreService.creaTheatre(theatreName).getId();

    }

    public int creatreScreenInTheatre(final String screenName, final int theatreId) throws Exception {

        final Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getScreenId();

    }

    public int createSeatInScreen(final Integer rowNo, final SeatCategory category, final int screenId)
            throws Exception {
        final Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(screenId, category, screen).getSeatID();
    }

}
