package DesignPatterns.ConcurrencyProblems;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    Semaphore zeroSemaphore;
    Semaphore OddSemaphore;
    Semaphore evenSemaphore;

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSemaphore = new Semaphore(1);
        OddSemaphore = new Semaphore(0);
        evenSemaphore = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean isOdd = true;
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (isOdd) {
                OddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
            isOdd = !isOdd;

        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            OddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }

    }

}
