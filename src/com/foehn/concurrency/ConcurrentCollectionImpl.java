/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 10405
 */
public class ConcurrentCollectionImpl {

    public static void main(String[] args) {
        // Map
        System.out.println("Map : ");
        Map<String, Object> foodData = new ConcurrentHashMap<>();
        foodData.put("punguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet()) {
            System.out.println("key = " + key);
            foodData.remove(key);
        }
        // Queue
        System.out.println("Queue : ");
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        // Deque
        System.out.println("Deque : ");
        Deque deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());
        // BlockingDeque
        System.out.println("BlockingDeque : ");
        try {
            BlockingDeque blockingDeque = new LinkedBlockingDeque();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MICROSECONDS));
            System.out.println(blockingDeque.poll(200, TimeUnit.MICROSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // CopyOnWriteArrayList
        System.out.println("CopyOnWriteArrayList : ");
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
        for (Integer item : list) {
            System.out.print(" item= " + item);
            list.add(9);
        }
        System.out.println(" Size: " + list.size());
        // Synchronized Collections method
        System.out.println("Synchronized Collections method : ");
        List<Integer> ilist = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4,3,52)));
        synchronized (ilist) {
            for (Integer data : ilist) {
                System.out.println(data + "");
            }
        }
    }
}
