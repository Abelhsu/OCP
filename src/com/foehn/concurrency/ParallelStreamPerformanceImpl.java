/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.ArrayList;
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

    public void processAllData(List<Integer> data) {
        data.stream().map(a -> processRecord(a)).count();
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
        impl.processAllData(data);
        double time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("\nTasks completed in: " + time + " seconds");
    }
}
