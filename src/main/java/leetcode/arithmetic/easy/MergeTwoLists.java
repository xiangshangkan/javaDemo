package leetcode.arithmetic.easy;

/**
 * @Description:  合并两个有序链表 leetcode 21
 * @Author: Zohar
 * @Date: 2020/7/17 14:16
 * @Version: 1.0
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode some = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode other = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode res =mergeTwoLists(some,other);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode start = l;
        do {
            if (l1 == null) {
                l.next = l2;
                break;
            }
            if (l2 == null) {
                l.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            } else {
                l.next = l1;
                l = l.next;
                l1 = l1.next;
            }

        } while(l2 != null || l1 != null);
        return start.next;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
