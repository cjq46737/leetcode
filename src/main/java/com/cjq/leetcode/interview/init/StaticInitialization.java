/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.init
 * @className com.cjq.leetcode.interview.init.StaticInitialization
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.init;


/**
 * StaticInitialization
 * @description 测试类初始化启动类
 * @author chenjunqi
 * @date 2022年08月08日 下午8:35
 * @version 3.0.0
 */
public class StaticInitialization {

    static Table table = new Table();

    static Cupboard cupboard = new Cupboard();

    public static void main(String[] args) {
        System.out.println("main..........");
        cupboard.otherMethod(1);
    }
}
