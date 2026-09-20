package DesignPatterns.SystemDesign.TicketBookingSystem.Entities;

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

    public Theatre(int id, String name, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.screens = screens;
    }

}
