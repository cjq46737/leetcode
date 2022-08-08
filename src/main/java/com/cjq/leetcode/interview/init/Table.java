/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.init
 * @className com.cjq.leetcode.interview.init.Table
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.init;

import sun.tools.jconsole.Tab;

/**
 * Table
 * @description 测试类初始化，继承TableWare
 * @author chenjunqi
 * @date 2022年08月08日 下午8:28
 * @version 3.0.0
 */
public class Table extends TableWare {

    {
        System.out.println("table no static 代码块1。。。。");
    }

    Bowl bowl5 = new Bowl(5);

    {
        System.out.println("table no static 代码块2。。。。");
    }

    static Bowl bowl1 = new Bowl(1);

    static {
        System.out.println("table static 代码块");
    }

    public Table(){
        System.out.println("Table 构造方法");
    }

    static Bowl bowl2 = new Bowl(2);
}
