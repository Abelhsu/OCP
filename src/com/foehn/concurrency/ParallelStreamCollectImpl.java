/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author 10405
 */
public class ParallelStreamCollectImpl {

    public static void main(String[] args) {
        // ParallelStream.collect() - 3 parameters
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> sortedSet = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println("set = " + sortedSet);
        // ParallelStream.collect() - 1 parameter
        stream = Stream.of("w", "o", "l", "f").parallel();
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println("set = " + set);
        // ParallelStream.groupingByConcurrent()
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map = ohMy.collect(Collectors.groupingByConcurrent(String::length));
        System.out.println("map = " + map);
    }
}
