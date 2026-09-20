package DesignPatterns.SystemDesign.ATMMachine.Utilities;

import DesignPatterns.SystemDesign.ATMMachine.Interface.ATMState;
import DesignPatterns.SystemDesign.ATMMachine.States.HasCardState;
import DesignPatterns.SystemDesign.ATMMachine.States.IdleState;
import DesignPatterns.SystemDesign.ATMMachine.States.SelectOperationState;

public class ATMStateFactory {

    private static ATMStateFactory instace = null;

    private ATMStateFactory() {

    }

    public static ATMStateFactory getInstance() {
        if (instace == null) {
            instace = new ATMStateFactory();
        }
        return instace;
    }

    public ATMState createIdleState() {
        return new IdleState();
    }

    public ATMState createHasCardState() {
        return new HasCardState();
    }

    public ATMState createSelectOperationState() {
        return new SelectOperationState();
    }

    public ATMState createTransactioState() {
        return new TransactionState();
    }

}
