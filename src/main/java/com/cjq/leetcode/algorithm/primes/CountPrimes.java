/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm.binarytree
 * @className com.cjq.leetcode.algorithm.primes.cjq
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.primes;

/**
 * cjq
 * @description 计算小于n的质数和，比如你10，质数位2 3 5 7，返回4
 * @author chenjunqi
 * @date 2022年05月10日 下午8:46
 * @version 3.0.0
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        int i = c.countPrimes(5000000);
        System.out.println(i);
    }

    /**
     * CountPrimes
     * @description 埃氏筛选法
     * 合数=质数*质数 15=3*5
     * 合数=质数*合数 8=2*4，所以只要是质数的倍数就一定不是质数
     * 循环2到n，2是质数，那么2的倍数就不是质数，11是质数，那么11的倍数也不是质数
     * @param n 目标n
     * @return n以内质数的数量和
     * @author chenjunqi
     * @date 2022/5/12 下午4:32
     * @version 3.0.0
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        boolean[] flags = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flags[i]) {
                count++;
                for (int j = i; j < n; j = j + i) {
                    flags[j] = true;
                }
            }
        }
        return count;
    }
}
