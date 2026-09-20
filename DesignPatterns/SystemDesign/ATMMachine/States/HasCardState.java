package DesignPatterns.SystemDesign.ATMMachine.States;

import DesignPatterns.SystemDesign.ATMMachine.Interface.ATMState;

public class HasCardState implements ATMState {

    @Override
    public String getStateName() {
        return "HasCard State";

    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if (context.getCurrentCard() == null) {
            return context.getStateFactory().createIdleState();
        }
        if (context.getCurrentAccount() != null) {
            return context.getStateFactory().createSelectOperationState();
        }
        return this;
    }

}
