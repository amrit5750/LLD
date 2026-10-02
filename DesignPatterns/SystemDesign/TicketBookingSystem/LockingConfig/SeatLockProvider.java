package DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
        Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show, s -> new ConcurrentHashMap<>());
        synchronized (seatLocks) {

            for (Seat seat : seats) {
                if (seatLocks.containsKey(seat)) {
                    SeatLock existingLock = seatLocks.get(seat);
                    if (!existingLock.isLockExpired()) {
                        throw new Exception("Seat  " + seat.getSeatID() + " is already Locked");
                    }
                }
            }

            Date date = new Date();
            for (Seat seat : seats) {
                SeatLock lock = new SeatLock(seat, show, locktimeOut, date, user);
                seatLocks.put(seat, lock);

            }

        }
    }

    @Override
    public void unLockSeats(Show show, List<Seat> seats, User user) throws Exception {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if (seatLocks == null) {
            return;
        }
        synchronized (seatLocks) {
            for (Seat seat : seats) {
                SeatLock lock = seatLocks.get(seat);
                if (lock != null && lock.getUser().equals(user)) {
                    seatLocks.remove(seat);
                }
            }

        }
    }

    @Override
    public boolean validateLock(Show show, Seat seat, User user) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if (seatLocks == null) {
            return false;
        }
        synchronized (seatLocks) {
            SeatLock lock = seatLocks.get(seat);
            if (lock != null && lock.getUser().equals(user) && !lock.isLockExpired()) {
                return true;
            }

        }
        return false;

    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if (seatLocks == null) {
            return Collections.emptyList();
        }

        synchronized (seatLocks) {
            return seatLocks.entrySet().stream().filter(entry -> !entry.getValue().isLockExpired())
                    .map(Map.Entry::getKey).collect(Collectors.toList());
        }

    }

}
