/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.teststatic.method
 * @className com.cjq.leetcode.interview.teststatic.clazz.TTT
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.teststatic.clazz;

/**
 * TTT
 * @description 测试静态变量和静态块的执行顺序
 * @author chenjunqi
 * @date 2022年07月27日 下午10:03
 * @version 3.0.0
 */
public class TTT {

    private static RRR r = new RRR();

    static {
        System.out.println("9999");
    }


    public static void main(String[] args) {
        new TTT();
    }

    public static class RRR{

        public RRR(){
            System.out.println("this is class RRR construct method....");
        }
    }
}
