/*
 * @projectName leetcode
 * @package com.cjq.leetcode.interview.equals
 * @className com.cjq.leetcode.interview.equals.User
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.interview.equals;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User
 * @description 两个对象的equals相等，但是hashcode不同
 * @author chenjunqi
 * @date 2022年07月16日 下午9:46
 * @version 3.0.0
 */
@Data
@AllArgsConstructor
public class TestUserEquals {

    private String name;

    private String age;

    public static void main(String[] args) {
        TestUserEquals u1 = new TestUserEquals("cjq", "1");
        TestUserEquals u2 = new TestUserEquals("lsy", "2");
        System.out.println(u1.equals(u2));
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());
    }

    public boolean equals(Object obj) {
        return true;
    }
}
