/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm.kuohao
 * @className com.cjq.leetcode.algorithm.kuohao.CheckIsVaild
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.kuohao;

import java.util.Stack;

/**
 * CheckIsVaild
 * @description 给定一个字符串，判断括号是否正常匹配
 * @author chenjunqi
 * @date 2022年05月10日 下午7:59
 * @version 3.0.0
 */
public class CheckIsVaild {

    public static void main(String[] args) {
        CheckIsVaild checkIsVaild = new CheckIsVaild();
        checkIsVaild.isValid("{");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char target : chars) {
            if (target == '(' || target == '{' || target == '[') {
                stack.push(target);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (target == ')' && pop != '(') {
                    return false;
                }
                if (target == ']' && pop != '[') {
                    return false;
                }
                if (target == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
