/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm.reverse
 * @className com.cjq.leetcode.algorithm.reverse.ReverseNum
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.reverse;

/**
 * ReverseNum
 * @description 计算数字反转，123变成321
 * @author chenjunqi
 * @date 2022年04月20日 下午10:12
 * @version 3.0.0
 */
public class ReverseNum {

    public static void main(String[] args) {
        int reverse = new ReverseNum().reverse(-2147483648);
        System.out.println(reverse);

    }

    public int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        StringBuilder s = new StringBuilder();
        boolean flag = x < 0;
        if (flag) {
            x = -x;
        }

        while (true) {
            s.append(x % 10);
            x = x / 10;
            if (x == 0) {
                break;
            }
        }
        String result = s.toString();
        if (Long.parseLong(result) > Integer.MAX_VALUE) {
            return 0;
        }
        return flag ? Integer.parseInt("-" + result) : Integer.parseInt(result);
    }
}
