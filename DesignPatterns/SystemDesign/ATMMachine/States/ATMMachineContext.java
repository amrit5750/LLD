package DesignPatterns.SystemDesign.ATMMachine.States;

import DesignPatterns.SystemDesign.ATMMachine.Interface.ATMState;
import DesignPatterns.SystemDesign.ATMMachine.Inventory.ATMInventory;
import DesignPatterns.SystemDesign.ATMMachine.Inventory.CashType;
import DesignPatterns.SystemDesign.ATMMachine.Utilities.ATMStateFactory;
import DesignPatterns.SystemDesign.ATMMachine.Utilities.TransactionState;

import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;

import DesignPatterns.SystemDesign.ATMMachine.Entity.Account;
import DesignPatterns.SystemDesign.ATMMachine.Entity.Card;

public class ATMMachineContext {

    private ATMState currentStage;
    private Card currentCard;
    private Account currentAccount;
    private ATMInventory atmInventory;
    Map<String, Account> accounts;
    private ATMStateFactory stateFactory;
    private TransactionType selectedOperation;

    public ATMMachineContext() {
        this.stateFactory = ATMStateFactory.getInstance();
        this.currentStage = stateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        accounts = new HashMap<>();
        System.out.println("ATM init is" + currentStage.getStateName());
    }

    public void advanceStage() {
        ATMState nexState = currentStage.next(this);
        currentStage = nexState;
        System.out.println("Currrent stage " + currentStage.getStateName());
    }

    public void insertCard(Card card) {
        if (currentStage instanceof IdleState) {
            System.out.println("card Inserted");
            this.currentCard = card;
            advanceStage();

        } else {
            System.out.println("card cannot be insered in " + currentStage.getStateName());
        }
    }

    public void enterPin(int pin) {
        if (currentStage instanceof HasCardState) {
            if (currentCard.validatePin(pin)) {
                System.out.println("Pin Authenticated Successfully");
                currentAccount = accounts.get(currentCard.getAccountNumber());
                advanceStage();
            } else {
                System.out.println("Invalid Pin , Please try again");
            }

        } else {
            System.out.println("Cannot enter pin in stage " + currentStage.getStateName());
        }

    }

    public void selectOperation(TransactionType transactionType) {
        if (currentStage instanceof SelectOperationState) {
            System.out.println("Selected Operation :" + transactionType);
            this.selectedOperation = transactionType;
            advanceStage();

        } else {
            System.out.println("cannot Select Operation in  " + currentStage.getStateName());
        }

    }

    public void performTrasaction(double amount) {
        if (currentStage instanceof TransactionState) {
            try {
                if (selectedOperation == TransactionType.WITHDRAW_CASH) {
                    performTrasaction(amount);
                } else if (selectedOperation == TransactionType.CHECK_BALANCE) {
                    checkBalance();
                }
                advanceStage();
            } catch (Exception e) {
                System.out.println("Transaction failed");
                currentStage = stateFactory.createSelectOperationState();
            }
        } else {
            System.out.println("cannot perform operation in " + currentStage.getStateName());
        }
    }

    public void returnCard() {
        if (currentStage instanceof HasCardState || currentStage instanceof SelectOperationState
                || currentStage instanceof TransactionState) {
            System.out.println("Returning card");
            ResetATM();
        } else {
            System.out.println("cannot return card  in " + currentStage.getStateName());
        }
    }

    public void ResetATM() {
        this.currentCard = null;
        this.currentAccount = null;
        this.selectedOperation = null;
        this.currentStage = stateFactory.createIdleState();

    }

    public void cancelTransaction() {
        if (currentStage instanceof TransactionState) {
            System.out.println("Transaction cancelled");
            returnCard();
        } else {
            System.out.println("No Transaction to Cancel " + currentStage.getStateName());
        }
    }

    public void performWithDraw(double amount) throws Exception {
        if (!currentAccount.withdraw(amount)) {
            throw new Exception("Insufficient funds in ATM");
        }

        if (atmInventory.hasSufficientCash((int) amount)) {
            currentAccount.deposit(amount);
            throw new Exception("Insufficient Amount in ATM");
        }

        Map<CashType, Integer> dispensedCash = atmInventory.dispenseCash((int) amount);

        if (dispensedCash == null) {
            currentAccount.deposit(amount);
            throw new Exception("Unable to dispense Exact Amount");
        }
        System.out.println("transactionm Successfull !! collect your CASH");
        for (Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
            System.out.println(entry.getKey() + "$" + entry.getValue());

        }

    }

    private void checkBalance() {
        System.out.println("Balance is " + currentAccount.getBalance());
    }

    public ATMState getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(ATMState currentStage) {
        this.currentStage = currentStage;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public ATMInventory getAtmInventory() {
        return atmInventory;
    }

    public ATMStateFactory getStateFactory() {
        return stateFactory;
    }

    public TransactionType getSelectedOperation() {
        return selectedOperation;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);

    }

}
