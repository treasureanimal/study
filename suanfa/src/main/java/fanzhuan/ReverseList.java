package fanzhuan;

/**
 * @author cheche
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }
    }

    /**
     * 使用迭代进行链表反转
     */
    public static ListNode iterate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        //因为不知道链表的长度所以不能用for循环，循环ListNode没有迭代器所以不能用forEach遍历
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 递归
     */
    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode recursion = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return recursion;
    }

    public static void addNode(int val, ListNode listNode) {
        ListNode listNode1 = new ListNode();
        listNode1.val = val;
        if (listNode.next == null) {
            listNode.next = listNode1;
            return;
        }
        ListNode temp = listNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = listNode1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        for (int i = 1; i < 5; i++) {
            addNode(i, listNode);
        }
        ListNode iterate = iterate(listNode);
        System.out.println("iterate = " + iterate);
        ListNode recursion = recursion(iterate);
        System.out.println("recursion = " + recursion);
    }

}
