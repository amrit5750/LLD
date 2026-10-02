package DesignPatterns.SystemDesign.TicketBookingSystem.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Movie;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Screen;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;

public class ShowService {
    private final Map<Integer, Show> shows;
    private final AtomicInteger showCounter;

    public ShowService(Map<Integer, Show> shows, AtomicInteger showCounter) {
        this.shows = new HashMap<>();
        this.showCounter = new AtomicInteger(0);
    }

    public Show getShow(final int showId) throws Exception {

        if (shows.containsKey(showId)) {
            throw new Exception("Cannot find show with show id : " + showId);
        }
        return shows.get(showId);

    }

    public Show createShow(final Movie movie, final Screen screen, final Date startTime,
            final Integer durationInSeconds) {
        int showId = showCounter.getAndIncrement();
        final Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        this.shows.put(showId, show);
        return show;

    }

    private List<Show> getShowsForScreen(final Screen screen) {

        final List<Show> response = new ArrayList<>();
        for (Show show : shows.values()) {
            if (show.getScreen().getScreenId() == screen.getScreenId()) {
                response.add(show);
            }
        }
        return response;
    }

}
