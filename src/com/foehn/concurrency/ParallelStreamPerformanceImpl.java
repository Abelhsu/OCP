/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 10405
 */
public class ParallelStreamPerformanceImpl {

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input + 1;
    }

    public void processAllDataUseStream(List<Integer> data) {
        data.stream().map(a -> processRecord(a)).count();
    }

    public void processAllDataUseParallelStream(List<Integer> data) {
        data.parallelStream().map(a -> processRecord(a)).count();
    }

    public static void main(String[] args) {
        ParallelStreamPerformanceImpl impl = new ParallelStreamPerformanceImpl();
        // Define the data
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 4000; i++) {
            data.add(i);
        }
        // Process the data 
        long start = System.currentTimeMillis();
//        impl.processAllDataUseStream(data);
        double time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("\nStream tasks completed in: " + time + " seconds");
        //
        start = System.currentTimeMillis();
//        impl.processAllDataUseParallelStream(data);
        time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("\nParallelStream tasks completed in: " + time + " seconds");
        // Uppercase
        Arrays.asList("jackel", "kangaroo", "lemur", "flamingo", "penguin")
                .parallelStream()
                .map(s -> {
                    System.out.println("s = " + s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);

    }
}
