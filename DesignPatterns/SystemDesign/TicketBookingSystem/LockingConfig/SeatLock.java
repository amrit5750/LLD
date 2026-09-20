package DesignPatterns.SystemDesign.TicketBookingSystem.LockingConfig;

import java.time.Instant;
import java.util.Date;

import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Seat;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.Show;
import DesignPatterns.SystemDesign.TicketBookingSystem.Entities.User;

public class SeatLock {

    private Seat seat;
    private Show show;
    private Integer timeOutInSec;
    private Date lockTime;
    private User user;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Integer getTimeOutInSec() {
        return timeOutInSec;
    }

    public void setTimeOutInSec(Integer timeOutInSec) {
        this.timeOutInSec = timeOutInSec;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SeatLock(Seat seat, Show show, Integer timeOutInSec, Date lockTime, User user) {
        this.seat = seat;
        this.show = show;
        this.timeOutInSec = timeOutInSec;
        this.lockTime = lockTime;
        this.user = user;
    }

    public boolean isLockExpired() {
        final Instant lockiInstant = lockTime.toInstant().plusSeconds(timeOutInSec);
        final Instant curreInstant = new Date().toInstant();
        return lockiInstant.isBefore(curreInstant);
    }

}
