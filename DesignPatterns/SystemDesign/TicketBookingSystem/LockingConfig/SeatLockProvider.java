package DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.User;

public class SeatLockProvider implements ISeatLockProvider {

    private final Integer locktimeOut;
    private Map<Show, Map<Seat, SeatLock>> locks;

    public SeatLockProvider(Integer lockTimeOut) {
        this.locks = new ConcurrentHashMap<>();
        this.locktimeOut = lockTimeOut;

    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, User user) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lockSeats'");
    }

    @Override
    public void unLockSeats(Show show, List<Seat> seats, User user) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unLockSeats'");
    }

    @Override
    public boolean validateLock(Show show, Seat seat, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateLock'");
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLockedSeats'");
    }

}
