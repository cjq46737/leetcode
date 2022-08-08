/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.init
 * @className com.cjq.leetcode.interview.init.Cupboard
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.init;

/**
 * Cupboard
 * @description 测试类初始化，继承TableWare
 * @author chenjunqi
 * @date 2022年08月08日 下午8:32
 * @version 3.0.0
 */
public class Cupboard extends TableWare {

    Bowl bowl3 = new Bowl(3);

    static Bowl bowl4  = new Bowl(4);

    public Cupboard(){
        System.out.println("Cupboard 构造方法。。。。");
    }

    void otherMethod(int maker){
        System.out.println("Cupboard othermethod............" + maker);
    }

    static Bowl bowl5 = new Bowl(5);

}
