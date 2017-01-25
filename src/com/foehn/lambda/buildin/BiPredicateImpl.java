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
        // Predicate
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println("Predicate 1 = " + p1.test("Character"));
        System.out.println("Predicate 2 = " + p2.test(""));
        // BiPredicate
        BiPredicate<String, String> bp1 = String::startsWith;
        BiPredicate<String, String> bp2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println("BiPredicate 1 = " + bp1.test("chicken", "chick"));
        System.out.println("BiPredicate 2 = " + bp2.test("chicken", "chick"));
        // Default method
        Predicate<String> egg = e -> e.contains("egg");
        Predicate<String> brown = b -> b.contains("brown");
        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());
        System.out.println("egg = " + egg.test("egg"));
        System.out.println("otherEggs = " + otherEggs.test("eggbrown"));
    }
}
