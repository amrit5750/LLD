package DesignPatterns.SystemDesign.ATMMachine;

import DesignPatterns.SystemDesign.ATMMachine.Entity.Account;
import DesignPatterns.SystemDesign.ATMMachine.Entity.Card;
import DesignPatterns.SystemDesign.ATMMachine.States.ATMMachineContext;
import DesignPatterns.SystemDesign.ATMMachine.States.TransactionType;

public class ATMDemo {

    public static void main(String[] args) {

        ATMMachineContext atmMachineContext = new ATMMachineContext();
        atmMachineContext.addAccount(new Account("A1232343", 1000));
        atmMachineContext.addAccount(new Account("A1232344", 1000));

        try {
            System.out.println("Starting ATM Demo");

            atmMachineContext.insertCard(new Card("1235854", 0, "nvfkjnvfn b"));
            atmMachineContext.enterPin(123456);
            atmMachineContext.selectOperation(TransactionType.WITHDRAW_CASH);
            atmMachineContext.performTrasaction(100.0);
            atmMachineContext.selectOperation(TransactionType.CHECK_BALANCE);
            atmMachineContext.performTrasaction(0);
            atmMachineContext.returnCard();
            System.out.println("ATM Demo Completed");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
