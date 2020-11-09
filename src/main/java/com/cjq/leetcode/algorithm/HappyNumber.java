/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm
 * @className com.cjq.leetcode.algorithm.HappyNumber
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * HappyNumber
 * @description 快乐数
 * @author chenjunqi
 * @date 2020年11月09日 8:35 下午
 * @version 3.0.0
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(86));
        System.out.println(isHappy(23));
        System.out.println(isHappy(25));
    }

    public static boolean isHappy(int n) {
        Set<Integer> exists = new HashSet<>();
        while (true) {
            int result = 0;
            int length = String.valueOf(n).length();
            for (int i = length; i > 0; i--) {
                int ten = (int) Math.pow(10, i - 1);
                int quotient = n / ten;
                n = n - ten * quotient;
                result += quotient * quotient;
            }
            if (exists.contains(result)) {
                return false;
            } else {
                exists.add(result);
            }
            if (result == 1) {
                return true;
            }
            n = result;
        }
    }
}
