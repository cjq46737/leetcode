/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.fizzbuzz
 * @className com.cjq.leetcode.thread.fizzbuzz.FizzBuzzByLock
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.fizzbuzz;

import com.cjq.leetcode.common.IntConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FizzBuzzByLock
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月24日 17:39
 * @version 3.0.0
 */
public class FizzBuzzByLock {

    private Lock lock = new ReentrantLock();

    private Condition fizzCondition = lock.newCondition();

    private Condition buzzCondition = lock.newCondition();

    private Condition fizzbuzzCondition = lock.newCondition();

    private int n;

    public FizzBuzzByLock(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        Thread fizz = new Thread(() -> System.out.print("fizz、"));
        Thread buzz = new Thread(() -> System.out.print("buzz、"));
        Thread fizzbuzz = new Thread(() -> System.out.print("fizzbuzz、"));

        FizzBuzzByLock fizzBuzz = new FizzBuzzByLock(15);

        new Thread(() -> {
            try {
                fizzBuzz.fizz(fizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(buzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(fizzbuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number(new IntConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

    }
}
