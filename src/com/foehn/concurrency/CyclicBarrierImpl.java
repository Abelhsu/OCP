/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author 10405
 */
public class CyclicBarrierImpl {

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // CyclicBarrier 
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(15);
            CyclicBarrierImpl impl = new CyclicBarrierImpl();
            CyclicBarrier c1 = new CyclicBarrier(15);
            CyclicBarrier c2 = new CyclicBarrier(15, () -> System.out.println("*** Pen Cleaned!"));

            for (int i = 0; i < 15; i++) {
                service.submit(() -> impl.performTask(c1, c2));
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
