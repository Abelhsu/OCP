/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.lambda.buildin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 *
 * @author 10405
 */
public class BiConsumerImpl {

    public static void main(String[] args) {
        // <String, Integer>
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);
        System.out.println("map = " + map);
        // <String, String>
        Map<String, String> map2 = new HashMap<>();
        BiConsumer<String, String> bc1 = map2::put;
        BiConsumer<String, String> bc2 = (k, v) -> map2.put(k, v);
        bc1.accept("chicken", "cluck");
        bc2.accept("chick", "tweep");
        System.out.println("map2 = " + map2);
    }
}
