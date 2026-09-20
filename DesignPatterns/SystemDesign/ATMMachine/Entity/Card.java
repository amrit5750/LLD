package DesignPatterns.SystemDesign.ATMMachine.Entity;

public class Card {

    private String cardNumber;
    private int pin;
    private String accountNumber;

    public Card(String cardNumber, int pin, String accountNumber) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(int enteredPin) {
        return enteredPin == this.pin;

    }

}
