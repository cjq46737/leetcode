/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.teststatic.clazz
 * @className com.cjq.leetcode.interview.teststatic.clazz.InitTest
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.teststatic.clazz;

/**
 * InitTest
 * @description 测试对象的初始化方法
 * @author chenjunqi
 * @date 2022年07月28日 下午8:32
 * @version 3.0.0
 */
public class InitTest {

    public static void main(String[] args) {
        A a = new B();
        a = new B();
    }


    public static class A{

        static{
            System.out.println("A static...");
        }

        public A(){
            System.out.println("A construct...");
        }
    }

    public static class B extends A{

        static{
            System.out.println("B static...");
        }

        public B(){
            System.out.println("B construct...");
        }
    }
}
