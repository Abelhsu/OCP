/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

/**
 *
 * @author 10405
 */
public class PollingImpl {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                PollingImpl.counter++;
            }
        }).start();
        while (PollingImpl.counter < 100) {
            System.out.println("Not reached yet, counter= " + PollingImpl.counter);
            Thread.sleep(1000);
        }
        System.out.println("Reached counter= " + PollingImpl.counter);
    }
}
