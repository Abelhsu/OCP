/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.lambda.buildin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 *
 * @author 10405
 */
public class BiSupplierImpl {

    public static void main(String[] args) {
        // LocalDate.now()
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("LocalDate= " + LocalDate.now());
        // StringBuilder()
        Supplier<StringBuilder> sb1 = StringBuilder::new;
        Supplier<StringBuilder> sb2 = () -> new StringBuilder();
        System.out.println("sb1.get() = " + sb1.get().append("OK!"));
        System.out.println("sb2.get() = " + sb2.get().append("Not OK!"));
        // ArrayList
        Supplier<ArrayList<String>> a1 = ArrayList<String>::new;
        Supplier<ArrayList<String>> a2 = () -> new ArrayList<>();
        System.out.println("a1 = " + a1.get());
        System.out.println("a2 = " + a2.get());
    }
}
