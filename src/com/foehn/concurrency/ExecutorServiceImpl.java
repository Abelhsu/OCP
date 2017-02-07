/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author 10405
 */
public class ExecutorServiceImpl {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                for (int i = 0; i < 30; i++) {
                    System.out.println("Printing record = " + i);
                }
            });
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
