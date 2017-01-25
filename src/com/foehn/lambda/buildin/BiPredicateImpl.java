/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.lambda.buildin;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author 10405
 */
public class BiPredicateImpl {

    public static void main(String[] args) {
        // isEmpty()
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println("Predicate 1 = " + p1.test("Character"));
        System.out.println("Predicate 2 = " + p2.test(""));
        // startWith()
        BiPredicate<String, String> bp1 = String::startsWith;
        BiPredicate<String, String> bp2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println("BiPredicate 1 = " + bp1.test("chicken", "chick"));
        System.out.println("BiPredicate 2 = " + bp2.test("chicken", "chick"));
    }
}
