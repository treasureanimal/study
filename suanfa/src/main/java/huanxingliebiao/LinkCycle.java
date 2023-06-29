package huanxingliebiao;

import java.util.HashSet;
import java.util.Set;

//判断链表中是否有环
public class LinkCycle {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        listNode5.next = listNode3; //当listNode5的下一个节点指向listNode3时说明是个环形列表
        System.out.println(hasCycle(listNode1));
        System.out.println(hasCycle(listNode2));
    }

    //set是不能重复的，时间和空间复杂度都为O(N)
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();


        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //使用双指针时间复杂度O（N）空间复杂度降低
    private static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
       ListNode slow =head;
       ListNode quick = head.next;

        while (slow != quick) {
            if (quick ==null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
            return false;
        }
        return true;
    }
}
