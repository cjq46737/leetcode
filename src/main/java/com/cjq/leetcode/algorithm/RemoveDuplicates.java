/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm
 * @className com.cjq.leetcode.algorithm.RemoveDuplicates
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm;

/**
 * RemoveDuplicates
 * @description 有序数组移除重复得数字
 * @author chenjunqi
 * @date 2020年11月20日 15:54
 * @version 3.0.0
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        //        //        int[] nums = new int[] { 1, 1 };
        //        //        int[] nums = new int[] {};
        int result = removeDuplicatesMethod(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(result);
    }

    private static int removeDuplicatesMethod(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[i] < nums[j]) {

                    int temp = nums[i + 1];
                    nums[i + 1] = nums[j];
                    nums[j] = temp;

                    if (nums[i + 1] == max) {
                        return i + 2;
                    }
                    break;
                }
            }
        }

        return 1;
    }
}
