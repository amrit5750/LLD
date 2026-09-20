package DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig;

import java.util.List;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.User;

public interface ISeatLockProvider {

    void lockSeats(Show show, List<Seat> seats, User user) throws Exception;

    void unLockSeats(Show show, List<Seat> seats, User user) throws Exception;

    boolean validateLock(Show show, Seat seat, User user);

    List<Seat> getLockedSeats(Show show);

}