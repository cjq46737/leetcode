/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.equals
 * @className com.cjq.leetcode.interview.equals.TestStringEquals
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.equals;

/**
 * TestStringEquals
 * @description 字符串对象的hashcode相同，但是equals返回false
 * @author chenjunqi
 * @date 2022年07月17日 上午10:18
 * @version 3.0.0
 */
public class TestStringEquals {

    public static void main(String[] args) {
        String s1 = "通话";
        String s2 = "重地";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
