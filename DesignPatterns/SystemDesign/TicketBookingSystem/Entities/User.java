package DesignPatterns.SystemDesign.TicketBookingSystem.Entities;

public class User {

    public final String name;
    public final String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
