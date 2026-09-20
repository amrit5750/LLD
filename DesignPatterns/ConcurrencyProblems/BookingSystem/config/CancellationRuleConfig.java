package DesignPatterns.ConcurrencyProblems.BookingSystem.config;

public class CancellationRuleConfig {

    private int freeCancellationHours;
    private int beforeWeekPenality;
    private int withinWeekPenality;

    public int getFreeCancellationHours() {
        return freeCancellationHours;
    }

    public void setFreeCancellationHours(int freeCancellationHours) {
        this.freeCancellationHours = freeCancellationHours;
    }

    public int getBeforeWeekPenality() {
        return beforeWeekPenality;
    }

    public void setBeforeWeekPenality(int beforeWeekPenality) {
        this.beforeWeekPenality = beforeWeekPenality;
    }

    public int getWithinWeekPenality() {
        return withinWeekPenality;
    }

    public void setWithinWeekPenality(int withinWeekPenality) {
        this.withinWeekPenality = withinWeekPenality;
    }

}
