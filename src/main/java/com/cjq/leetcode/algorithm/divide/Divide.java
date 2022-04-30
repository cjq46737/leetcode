/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm.divide
 * @className com.cjq.leetcode.algorithm.divide.Divide
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.divide;

/**
 * Divide
 * @description 两数相除，不要除法
 * @author chenjunqi
 * @date 2022年04月30日 上午8:29
 * @version 3.0.0
 */
public class Divide {

    /**
     * Divide
     * @description 通过位运算降低循环次数，如果一次次减可以通过全部测试用例，但是leetcode超时间。递归会栈溢出
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     * @author chenjunqi
     * @date 2022/4/30 上午8:30
     * @version 3.0.0
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        long dividendTemp = Math.abs((long) dividend);
        long divisorTemp = Math.abs((long) divisor);
        boolean flag = (dividend > 0 && divisor > 0) || (divisor < 0 && dividend < 0);
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if (dividendTemp >> i >= divisorTemp) {
                dividendTemp = dividendTemp - (divisorTemp << i);
                count += 1 << i;
            }
        }
        return flag ? count : -count;
    }
}
