package DesignPatterns.SystemDesign.ATMMachine.States;

import DesignPatterns.SystemDesign.ATMMachine.Interface.ATMState;

public class IdleState implements ATMState {

    @Override
    public String getStateName() {
        return "IdleState";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if (context.getCurrentCard() != null) {
            return context.getStateFactory().createHasCardState();
        }
        return this;
    }

}
