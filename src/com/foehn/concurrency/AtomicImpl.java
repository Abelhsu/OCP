/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author 10405
 */
public class AtomicImpl {

    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementReport() {
        // 將方法 synchronized
        synchronized (this) {
            System.out.println(sheepCount.incrementAndGet() + "");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            AtomicImpl impl = new AtomicImpl();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> impl.incrementReport());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
