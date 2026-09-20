package DesignPatterns.SystemDesign.ATMMachine.States;

import DesignPatterns.SystemDesign.ATMMachine.Interface.ATMState;

public class SelectOperationState implements ATMState {

    @Override
    public String getStateName() {
        return "Select Operation State";
    }

    @Override
    public ATMState next(ATMMachineContext context) {

        if (context.getCurrentCard() == null) {
            return context.getStateFactory().createIdleState();
        }

        if (context.getSelectedOperation() != null) {
            return context.getStateFactory().createTransactioState();
        }
        return this;
    }

}
