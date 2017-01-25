package com.foehn.lambda;

import java.util.Optional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 10405
 */
public class OptionalImpl {

    public static void main(String[] args) {
        Optional<Double> opt = average(90,100);
        if (opt.isPresent()) {
            System.out.println("opt = " + opt.get());
        }
    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }
}
