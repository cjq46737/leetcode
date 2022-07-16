/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.i2s
 * @className com.cjq.leetcode.interview.i2s.TestI2s
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.i2s;

/**
 * TestI2s
 * @description 测试i2s
 * @author chenjunqi
 * @date 2022年07月16日 下午7:37
 * @version 3.0.0
 */
public class TestI2s {

    public static void main(String[] args) {
        short s1 = 1;
        // 编译报错，因为s1+1返回值是int没办法强转为short
        //        s1 = s1 + 1;
        s1 += 1;

    }
}
