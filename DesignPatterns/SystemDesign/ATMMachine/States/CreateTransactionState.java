package DesignPatterns.SystemDesign.ATMMachine.States;

import DesignPatterns.SystemDesign.ATMMachine.Interface.ATMState;

class createTransactionState implements ATMState {

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
