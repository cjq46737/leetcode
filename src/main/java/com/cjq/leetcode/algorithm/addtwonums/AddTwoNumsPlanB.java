/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm
 * @className com.cjq.leetcode.algorithm.CJq
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.addtwonums;

/**
 * AddTwoNumsPlanB
 * @description 这种算法对于int范围以内的数字是可以的，如果超出int范围就会报错，比如[9]和[1,9,9,9,9,9,9,9,9,9]
 * @author chenjunqi
 * @date 2022年04月14日 下午8:23
 * @version 3.0.0
 */
public class AddTwoNumsPlanB {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9, l1);
        ListNode l3 = new ListNode(9, l2);
        ListNode l4 = new ListNode(9, l3);

        ListNode l11 = new ListNode(9);
        ListNode l21 = new ListNode(9, l11);
        ListNode l31 = new ListNode(9, l21);
        ListNode l41 = new ListNode(9, l31);
        ListNode l22 = new ListNode(9, l41);
        ListNode l32 = new ListNode(9, l22);
        ListNode l42 = new ListNode(9, l32);
        //                ListNode l221 = new ListNode(9, l42);
        //                ListNode l321 = new ListNode(9, l221);
        //        ListNode l421 = new ListNode(1, l321);

        //        ListNode l11 = new ListNode(3);
        //        ListNode l21 = new ListNode(4, l11);
        //        ListNode l31 = new ListNode(2, l21);
        //
        //        ListNode l1 = new ListNode(4);
        //        ListNode l2 = new ListNode(6, l1);
        //        ListNode l3 = new ListNode(5, l2);

        AddTwoNumsPlanB addTwoNumsPlanB = new AddTwoNumsPlanB();
        ListNode result = addTwoNumsPlanB.addTwoNumbers(l4, l42);
        System.out.println(result);

    }

    /**
     * AddTwoNumsPlanB
     * @description 真正的计算逻辑
     * @param l1 l1
     * @param l2 l2
     * @param result 计算结果
     * @author chenjunqi
     * @date 2022/4/16 上午11:02
     * @version 3.0.0
     */
    public static void calculate(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null && l2 == null) {
            return;
        }
        int num = (l2 == null ? 0 : l2.val) + (l1 == null ? 0 : l1.val) + result.val;
        ListNode temp;
        if (num >= 10) {
            result.val = num - 10;
            temp = new ListNode(1);
        } else {
            result.val = num;
            temp = new ListNode();
        }

        // 到这里，要么l1和l2至少一个不是null，如果都为null，方法第一行就会返回
        if (l1 == null) {
            if (l2.next == null && temp.val == 0) {
                return;
            }
            result.next = temp;
            calculate(null, l2.next, temp);
        } else if (l2 == null) {
            if (l1.next == null && temp.val == 0) {
                return;
            }
            result.next = temp;
            calculate(l1.next, null, temp);
        } else {
            if (l1.next == null && l2.next == null && temp.val == 0) {
                return;
            }
            result.next = temp;
            calculate(l1.next, l2.next, temp);
        }
    }

    /**
     * AddTwoNumsPlanB
     * @description 方法的入口
     * @param l1 第一个节点
     * @param l2 第二个节点
     * @return 计算结果
     * @author chenjunqi
     * @date 2022/4/16 上午11:03
     * @version 3.0.0
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        calculate(l1, l2, result);
        return result;
    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
