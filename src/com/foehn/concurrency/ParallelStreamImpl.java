/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author 10405
 */
public class ParallelStreamImpl {

    public static void main(String[] args) {
        // Create parallel stream (1)
        Stream<Integer> parallelStream = Arrays.asList(1, 2, 3, 4, 5, 6).stream().parallel();
        parallelStream.forEach(System.out::println);
        // Create parallel stream (2)
        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();
        System.out.println();
        parallelStream2.forEachOrdered(System.out::println);
    }
}
