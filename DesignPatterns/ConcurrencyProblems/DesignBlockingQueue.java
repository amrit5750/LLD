package DesignPatterns.ConcurrencyProblems;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class DesignBlockingQueue {

    private Semaphore full; // keep the track of filled Slots in Queue
    private Semaphore empty; // keep the track of Empty slots in Queue

    private ConcurrentLinkedDeque<Integer> deque;

    DesignBlockingQueue(int Capacity) {
        full = new Semaphore(0);
        empty = new Semaphore(Capacity);
        deque = new ConcurrentLinkedDeque<>();
    }

    public void enQueue(int element) throws InterruptedException {

        empty.acquire();
        deque.addFirst(element);
        full.release();

    }

    public int deQueue() throws InterruptedException {
        int result = -1;
        full.acquire();
        result = deque.pollLast();
        empty.release();
        return result;

    }

    public int size() throws InterruptedException {
        return deque.size();

    }

}
