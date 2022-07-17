/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview
 * @className com.cjq.leetcode.interview.reference.Test
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.reference;

import com.cjq.leetcode.interview.equals.TestUserEquals;

/**
 * Test
 * @description 测试值引用、引用传递
 * @author chenjunqi
 * @date 2022年07月17日 上午11:09
 * @version 3.0.0
 */
public class TestReference {

    public static void main(String[] args) {
        TestReference test = new TestReference();

        TestUserEquals equals = new TestUserEquals("cjq", "1");
        TestUserEquals ff = test.changeReference(equals);
        System.out.println(ff);
        System.out.println(equals.getAge());

        TestUserEquals t1 = test.changeValues(equals);
        System.out.println(t1.hashCode() + "----" + t1.getAge());
        System.out.println(equals.hashCode() + "----" + equals.getAge());
    }

    public TestUserEquals changeReference(TestUserEquals testUserEquals) {
        testUserEquals = null;
        return testUserEquals;
    }

    public TestUserEquals changeValues(TestUserEquals testUserEquals) {
        return testUserEquals.setAge("111");
    }
}
