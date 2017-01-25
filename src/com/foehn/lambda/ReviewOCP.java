/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.lambda;

import java.util.stream.Stream;

/**
 *
 * @author 10405
 */
public class ReviewOCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(15, x -> x + 33);
        System.out.println(stream.limit(5).map(x -> x + 10));
    }
    
}
