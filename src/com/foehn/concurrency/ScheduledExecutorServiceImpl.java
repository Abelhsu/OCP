/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 10405
 */
public class ScheduledExecutorServiceImpl {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        ScheduledFuture<?> result1 = service.schedule(task1, 1, TimeUnit.SECONDS);
        ScheduledFuture<String> result2 = service.schedule(task2, 12, TimeUnit.SECONDS);
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("processors = " + processors);
    }
}
