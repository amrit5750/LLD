package DesignPatterns.SystemDesign.ATMMachine.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ATMInventory {

    private Map<CashType, Integer> cashInventory;

    public ATMInventory() {
        cashInventory = new HashMap<>();
        initiInventory();
    }

    public void initiInventory() {
        cashInventory.put(CashType.BILL_100, 10);
        cashInventory.put(CashType.BILL_50, 10);
        cashInventory.put(CashType.BILL_20, 20);
        cashInventory.put(CashType.BILL_10, 30);
        cashInventory.put(CashType.BILL_5, 10);
        cashInventory.put(CashType.BILL_1, 10);

    }

    public int getTotalCash() {
        int total = 0;

        for (Entry<CashType, Integer> entry : cashInventory.entrySet()) {
            total += entry.getKey().value * entry.getValue();
        }
        return total;
    }

    public boolean hasSufficientCash(int amount) {
        return getTotalCash() >= amount;
    }

    public Map<CashType, Integer> dispenseCash(int amount) {
        if (!hasSufficientCash(amount)) {
            return null;
        }
        Map<CashType, Integer> dispensedCash = new HashMap<>();
        int remainingAmount = amount;
        for (CashType cashType : CashType.values()) {
            int count = Math.min(cashInventory.get(cashType), remainingAmount / cashType.value);
            if (count > 0) {
                dispensedCash.put(cashType, count);
                remainingAmount -= count * cashType.value;
                cashInventory.put(cashType, cashInventory.get(cashType) - count);
            }

        }
        if (remainingAmount > 0) {
            for (Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
                cashInventory.put(entry.getKey(), cashInventory.get(entry.getKey()) + entry.getValue());

            }
            return null;
        }
        return dispensedCash;
    }

    public void addCash(CashType cashType, int count) {
        cashInventory.put(cashType, cashInventory.get(cashType) + count);
    }

}
