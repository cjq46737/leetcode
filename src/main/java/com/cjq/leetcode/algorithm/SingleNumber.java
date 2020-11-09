/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm
 * @className com.cjq.leetcode.algorithm.SingleNumber
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm;

/**
 * SingleNumber
 * @description 数组中只出现一次的数字
 * @author chenjunqi
 * @date 2020年11月09日 8:39 下午
 * @version 3.0.0
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 2, 3, 5, 5, 3 };
        System.out.println(singleNumber(nums));
    }

    /**
     * SingleNumber
     * @description 异或，相同结果为0，不同结果为1。n^n=0,0^n=n.
     * @param nums nums
     * @return int
     * @author chenjunqi
     * @date 2020/11/9 8:41 下午
     * @version 3.0.0
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
