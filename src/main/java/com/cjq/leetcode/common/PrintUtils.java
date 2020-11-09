/*
 * @projectName leetcode
 * @package com.cjq.leetcode.common
 * @className com.cjq.leetcode.common.PrintUtils
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.common;

import lombok.experimental.UtilityClass;

/**
 * PrintUtils
 * @description TODO
 * @author chenjunqi
 * @date 2020年11月09日 8:29 下午
 * @version 3.0.0
 */
@UtilityClass
public class PrintUtils {

    public static void printArray(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
