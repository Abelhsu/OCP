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
public class ThreadImpl extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Print i= " + i);
        }
    }

    public static void main(String[] args) {
        new ThreadImpl().start();
        new ThreadImpl().start();
        new ThreadImpl().start();
    }

}
