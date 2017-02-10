/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.Arrays;

/**
 *
 * @author 10405
 */
public class ParallelStreamReduceImpl {

    public static void main(String[] args) {
        // Stream.reduce() - 3 parameters
        System.out.println("Stream.reduce() :");
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream()
                .reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3)
        );
        // ParallelStream.recuce()
        System.out.println("ParallelStream.reduce() :");
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, (a, b) -> (a - b)));
        //
        System.out.println("ParallelStream.reduce() :");
        System.out.println(Arrays.asList("w", "o", "l", "f")
                .parallelStream()
                .reduce("X", String::concat)
        );
    }
}
