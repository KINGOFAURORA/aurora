package com.aurora.leetcode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Question206 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(4);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(5);
        ln4.next = ln5;

        ln1 = reverseList(ln1);

        while (ln1 != null) {
            System.out.println(ln1.val);
            ln1 = ln1.next;
        }
    }
}
