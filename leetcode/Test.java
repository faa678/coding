package com.faa.coding.leetcode;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Test {

    int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};


    public static void test(AtomicInteger at) {
        System.out.println(at.get());
        System.out.println(at.getAndAdd(3));
        System.out.println(at.addAndGet(2));
        System.out.println(at.getAndSet(5));
        System.out.println(at.getAndIncrement());
        System.out.println(at.getAndDecrement());
        System.out.println(at.compareAndSet(3,6));
        System.out.println(at.get());
        at.lazySet(8);
        System.out.println(at.get());
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        AtomicInteger at = new AtomicInteger(5);
        test(at);
    }
}
