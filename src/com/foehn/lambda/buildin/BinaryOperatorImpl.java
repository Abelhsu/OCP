/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.lambda.buildin;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 *
 * @author 10405
 */
public class BinaryOperatorImpl {

    public static void main(String[] args) {
        // UnaryOperator
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println("u1 = " + u1.apply("foehn"));
        System.out.println("u2 = " + u2.apply("bolzano"));
        //BinaryOperator
        BinaryOperator<String> bo1 = String::concat;
        BinaryOperator<String> bo2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println("bo1 = " + bo1.apply("Abel", " Hsu"));
        System.out.println("bo2 = " + bo2.apply("Cauchy", "Hsu"));
    }
}
