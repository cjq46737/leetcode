/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.trycatchfinlly
 * @className com.cjq.leetcode.interview.trycatchfinlly.TestTryCatchFinlly1
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.trycatchfinlly;

import java.util.Optional;

/**
 * TestTryCatchFinlly1
 * @description 测试try-catch-finally的执行顺序
 * @author chenjunqi
 * @date 2022年07月29日 上午10:59
 * @version 3.0.0
 */
public class TestTryCatchFinlly {

    public static void main(String[] args) {
//        System.out.println(test1());
//        System.out.println(test2());
        System.out.println(test3());
    }

    public static int test1(){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            System.out.print(3);
        }
    }

    public static int test2(){
        try{
            return 1;
        }finally {
            return 3;
        }
    }

    public static int test3(){
        int i = 0;
        try{
            i=2;
            return i;
        }finally {
            i=3;
        }
    }
}

