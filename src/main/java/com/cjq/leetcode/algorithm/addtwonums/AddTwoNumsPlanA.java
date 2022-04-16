/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm
 * @className com.cjq.leetcode.algorithm.CJq
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.addtwonums;

/**
 * CJq
 * @description 这种算法对于int范围以内的数字是可以的，如果超出int范围就会报错，比如[9]和[1,9,9,9,9,9,9,9,9,9]
 * @author chenjunqi
 * @date 2022年04月14日 下午8:23
 * @version 3.0.0
 */
public class AddTwoNumsPlanA {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l11 = new ListNode(1);
        ListNode l21 = new ListNode(9, l11);
        ListNode l31 = new ListNode(9, l21);
        ListNode l41 = new ListNode(9, l31);
        ListNode l22 = new ListNode(9, l41);
        ListNode l32 = new ListNode(9, l22);
        ListNode l42 = new ListNode(9, l32);
        ListNode l221 = new ListNode(9, l42);
        ListNode l321 = new ListNode(9, l221);
        ListNode l421 = new ListNode(9, l321);

        AddTwoNumsPlanA cJq = new AddTwoNumsPlanA();
        ListNode listNode = cJq.addTwoNumbers(l1, l421);
        System.out.println(listNode);

    }

    /**
     * AddTwoNumsPlanA
     * @description 通过递归把数字转为链表
     * @param i 需要转为链表的数字
     * @param node 转换后的链表
     * @author chenjunqi
     * @date 2022/4/14 下午9:16
     * @version 3.0.0
     */
    public static void ecrypt(int i, ListNode node) {
        if (i >= 10) {
            node.val = i % 10;
            i = i / 10;
            ListNode temp = new ListNode();
            node.next = temp;
            ecrypt(i, temp);
        } else {
            node.val = i;
        }

    }

    /**
     * AddTwoNumsPlanA
     * @description 把链表转为数字
     * @param l1 需要转换的链表
     * @return 转换后的数字
     * @author chenjunqi
     * @date 2022/4/14 下午9:17
     * @version 3.0.0
     */
    public static int decrypt(ListNode l1) {
        int n = l1.val;
        int i = 1;
        while (l1.next != null) {
            n += l1.next.val * Math.pow(10, i);
            i++;
            l1 = l1.next;
        }
        return n;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = decrypt(l1) + decrypt(l2);
        ListNode listNode = new ListNode();
        ecrypt(sum, listNode);
        return listNode;
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
