/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 10405
 */
public class AwaitTerminationImpl {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    AwaitTerminationImpl.counter++;
                    System.out.println("counter = " + AwaitTerminationImpl.counter);
                }
            });
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
        if (service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
            if (service.isTerminated()) {
                System.out.println("All tasks finished");
            } else {
                System.out.println("At least one task is still running!");
            }
        }
    }
}
