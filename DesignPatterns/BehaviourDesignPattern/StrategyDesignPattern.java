package DesignPatterns.BehaviourDesignPattern;

public class StrategyDesignPattern {

    public static void main(String[] args) {

        PaymentStrategy googlePay = new GooglePay();
        PaymentStrategy stripe = new Stripe();

        PaymentProcessor paymentProcessor = new PaymentProcessor(googlePay);
        paymentProcessor.processPayment();
        paymentProcessor.setPaymentStrategy(stripe);
        paymentProcessor.processPayment();

    }

}

/**
 * paymentMethod
 */
interface PaymentMethod {
    void processPayment();

}

/**
 * paymentStrategy
 */
interface PaymentStrategy {
    void processPayment();

}

class GooglePay implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Processing payment via GooglePay ");
    }
}

class Stripe implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Processing payment via Stripe ");
    }
}

class PhonePay implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Processing payment via PhonePay ");
    }
}

class Paytm implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Processing payment via paytm ");
    }
}

class PaymentProcessor {
    PaymentStrategy paymentStrategy;

    PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        paymentStrategy.processPayment();

    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

}

class PaymentProcessing {

    public static void processPayment(String paymentProcessType) {

        PaymentStrategy strategy = null;

        // if (paymentProcessType.equals("GooglePay")) {
        // System.out.println("Processing payment via " + paymentProcessType);
        // } else if (paymentProcessType.equals("Stripe")) {
        // System.out.println("Processing payment via + " + paymentProcessType);
        // } else if (paymentProcessType.equals("PhonePay")) {
        // System.out.println("Processing payment via + " + paymentProcessType);
        // } else if (paymentProcessType.equals("paytm")) {
        // System.out.println("Processing payment via + " + paymentProcessType);
        // } else {
        // System.out.println("Invalid paymentProcessType");
        // }

        if (paymentProcessType.equals("GooglePay")) {
            strategy = new GooglePay();

        } else if (paymentProcessType.equals("Stripe")) {
            strategy = new Stripe();
        } else if (paymentProcessType.equals("PhonePay")) {
            strategy = new PhonePay();
        } else if (paymentProcessType.equals("paytm")) {
            strategy = new Paytm();
        } else {
            System.out.println("Invalid paymentProcessType");
        }

        strategy.processPayment();
    }
}
