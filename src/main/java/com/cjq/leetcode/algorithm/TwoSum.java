/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm
 * @className com.cjq.leetcode.algorithm.TwoSUm
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm;

import com.cjq.leetcode.common.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSUm
 * @description 两数只和
 * @author chenjunqi
 * @date 2020年11月09日 8:16 下午
 * @version 3.0.0
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 9, 11, 15 };
        int target = 17;

        int[] result1 = twoSum_method1(nums, target);
        PrintUtils.printArray(result1);

        int[] result2 = twoSum_method2(nums, target);
        PrintUtils.printArray(result2);
    }

    /**
     * TwoSum
     * @description 时间复杂度n*n
     * @param nums nums
     * @param target target
     * @return int[]
     * @author chenjunqi
     * @date 2020/11/9 8:18 下午
     * @version 3.0.0
     */
    public static int[] twoSum_method1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * TwoSum
     * @description 时间复杂度n
     * @param nums nums
     * @param target target
     * @return int[]
     * @author chenjunqi
     * @date 2020/11/9 8:19 下午
     * @version 3.0.0
     */
    public static int[] twoSum_method2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
