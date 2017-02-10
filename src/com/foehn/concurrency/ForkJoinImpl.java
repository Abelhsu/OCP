/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author 10405
 */
public class ForkJoinImpl extends RecursiveTask {

    private int start;
    private int end;
    private Double[] weights;

    public ForkJoinImpl(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {
        if (end - start <= 3) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal weight = " + i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start + (end - start) / 2;
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
            RecursiveTask<Double> otherTask = new ForkJoinImpl(start, middle, weights);
            Double otherResult = otherTask.fork().join();
            return new ForkJoinImpl(middle, end, weights).compute() + otherResult;
        }
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];
        ForkJoinTask<Double> task = new ForkJoinImpl(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);
        System.out.println("sum = " + sum);
    }
}
