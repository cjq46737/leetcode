/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.teststatic.method
 * @className com.cjq.leetcode.interview.teststatic.method.TestStaticMethod
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.teststatic.method;

/**
 * TestStaticMethod
 * @description 测试静态方法调用非静态方法
 * @author chenjunqi
 * @date 2022年07月27日 下午9:50
 * @version 3.0.0
 */
public class TestStaticMethod {

    public static void main(String[] args) {
        TestStaticMethod testStaticMethod = new TestStaticMethod();
        testStaticMethod.f();
        //        f();

    }

    public void f() {
        System.out.println("this is method f.....");
    }
}
