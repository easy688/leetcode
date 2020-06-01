package com.easy688.learn;

import lombok.Data;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 
 * 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0
 * 开头输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author easy688
 */

public class TwoNumSumLinked {

    public static void main(String[] args) {
        ListNode l1=new ListNode(342);
        ListNode l2=new ListNode(465);
        ListNode resultNode=addTwoNumbers(l1,l2);
        System.out.println(resultNode.toString());

    }

    /**
     * 时间复杂度：O(\max(m, n))，假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，
     * 上面的算法最多重复 \max(m, n)max(m,n) 次
     * 空间复杂度：O(\max(m, n))，
     * 新列表的长度最多为 \max(m,n) + 1max(m,n)+1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    @Data
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
