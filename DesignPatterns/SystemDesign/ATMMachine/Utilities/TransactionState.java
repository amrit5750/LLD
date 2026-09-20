package DesignPatterns.SystemDesign.ATMMachine.Utilities;

import DesignPatterns.SystemDesign.ATMMachine.States.ATMMachineContext;
import DesignPatterns.SystemDesign.ATMMachine.Interface.ATMState;

public class TransactionState implements ATMState {

    @Override
    public String getStateName() {
        return "TransactionState";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if (context.getCurrentCard() == null) {
            return context.getStateFactory().createIdleState();

        }
        return context.getStateFactory().createSelectOperationState();
    }

}
