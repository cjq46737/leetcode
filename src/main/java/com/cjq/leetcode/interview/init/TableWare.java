/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.init
 * @className com.cjq.leetcode.interview.init.TableWare
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.init;

/**
 * TableWare
 * @description 测试类初始化，餐具，里面调用了Bowl类
 * @author chenjunqi
 * @date 2022年08月08日 下午8:25
 * @version 3.0.0
 */
public class TableWare {

    static Bowl bowl7 = new Bowl(7);

    static{
        System.out.println("TableWare static 代码快");
    }

    public TableWare(){
        System.out.println("TableWare 构造方法");
    }

    Bowl bowl6 = new Bowl(6);

}
