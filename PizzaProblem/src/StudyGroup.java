
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vijini
 */
public class StudyGroup {

    int S = 5;
    int slices = 0;

    private final Lock mutex = new ReentrantLock();

    private final Condition orderPizza = mutex.newCondition();
    private final Condition deliverPizza = mutex.newCondition();

    private boolean first = true;
    private boolean havePizza = false;

    void beginStudying() throws InterruptedException {
        mutex.lock();
        if (slices > 0) {
            --slices;
            System.out.println("Student " + Thread.currentThread().getId() + " took a slice of pizza and is studying");
        } else {
            if (first) {
                System.out.println("Group out of pizza. Student " + Thread.currentThread().getId() + " calls Kamal's Pizza and orders pizza");
                orderPizza.signal();
                first = false;
            }
            System.out.println("Student " + Thread.currentThread().getId() + " sleeps");
            deliverPizza.await();
        }
        mutex.unlock();
        
    }

    void checkOrder() throws InterruptedException {
        mutex.lock();
        slices = S;
        System.out.println("Pizza delivered");
        first = true;
        System.out.println("Wake up sleeping students\n");
        deliverPizza.signalAll();
        orderPizza.await();
        mutex.unlock();
        
    }

    
}
