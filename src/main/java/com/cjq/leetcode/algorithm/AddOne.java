/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm
 * @className com.cjq.leetcode.algorithm.AddOne
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm;

import com.cjq.leetcode.common.PrintUtils;

/**
 * AddOne
 * @description 数字+1
 * @author chenjunqi
 * @date 2020年11月09日 8:27 下午
 * @version 3.0.0
 */
public class AddOne {

    public static void main(String[] args) {
        int[] digits = new int[] { 8, 6, 6 };
        int[] result = addOne(digits);
        PrintUtils.printArray(result);
        System.out.println();
        PrintUtils.printArray(addOne(new int[] { 8, 9, 9 }));
        System.out.println();
        PrintUtils.printArray(addOne(new int[] { 9, 9, 9 }));

    }

    public static int[] addOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] >= 10 && i != 0) {
                digits[i] = digits[i] - 10;
                digits[i - 1] = digits[i - 1] + 1;
            }
        }
        if (digits[0] >= 10) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
