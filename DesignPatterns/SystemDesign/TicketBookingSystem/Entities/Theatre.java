package DesignPatterns.SystemDesign.TicketBookingSystem.Entities;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    public final int id;
    public final String name;
    public final List<Screen> screens;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public Theatre(int id, String theatreName) {
        this.id = id;
        this.name = theatreName;
        this.screens = new ArrayList<>();
    }

    public void addScreen(final Screen screen) {
        screens.add(screen);
    }

}
