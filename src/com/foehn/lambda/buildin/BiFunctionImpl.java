/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.lambda.buildin;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author 10405
 */
public class BiFunctionImpl {

    public static void main(String[] args) {
        // Function
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println("f1 = " + f1.apply("Foehn"));
        System.out.println("f2 = " + f2.apply("Cauchy Hsu"));
        // BiFunction
        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println("bf1 = " + bf1.apply("Abel", " Hsu"));
        System.out.println("bf2 = " + bf2.apply("Cauchy", " Hsu"));
    }
}
