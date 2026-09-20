package DesignPatterns.SystemDesign.ATMMachine.Interface;

import DesignPatterns.SystemDesign.ATMMachine.States.ATMMachineContext;

public interface ATMState {

    String getStateName();

    ATMState next(ATMMachineContext context);

}