/*
 * @projectName leetcode
 * @package com.cjq.leetcode.thread.fizzbuzz
 * @className com.cjq.leetcode.thread.fizzbuzz.FizzBuzz
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.thread.fizzbuzz;

import com.cjq.leetcode.common.IntConsumer;

import java.util.concurrent.Semaphore;

/**
 * FizzBuzz
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月24日 15:58
 * @version 3.0.0
 */
public class FizzBuzz {

    private Semaphore fizzSemaphore = new Semaphore(0);

    private Semaphore buzzSemaphore = new Semaphore(0);

    private Semaphore fizzbuzzSemaphore = new Semaphore(0);

    private Semaphore numSemaphore = new Semaphore(1);

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        Thread fizz = new Thread(() -> System.out.print("fizz、"));
        Thread buzz = new Thread(() -> System.out.print("buzz、"));
        Thread fizzbuzz = new Thread(() -> System.out.print("fizzbuzz、"));

        FizzBuzz fizzBuzz = new FizzBuzz(15);

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
        if (n < 3) {
            return;
        }
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizzSemaphore.acquire();
                printFizz.run();
                numSemaphore.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        if (n < 5) {
            return;
        }
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzzSemaphore.acquire();
                printBuzz.run();
                numSemaphore.release();
            }

        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        if (n < 15) {
            return;
        }
        for (int i = 15; i <= n; i += 15) {
            fizzbuzzSemaphore.acquire();
            printFizzBuzz.run();
            numSemaphore.release();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        numSemaphore.acquire();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzzSemaphore.release();
                numSemaphore.acquire();
            } else if (i % 3 == 0) {
                fizzSemaphore.release();
                numSemaphore.acquire();
            } else if (i % 5 == 0) {
                buzzSemaphore.release();
                numSemaphore.acquire();
            } else {
                printNumber.accept(i);
            }
        }

    }
}
