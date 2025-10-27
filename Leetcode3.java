public class Leetcode3 {

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0, null);

        ListNode ans = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = new ListNode(list1.val, null);
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val, null);
                head = head.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            head.next = list1;
        }

        if (list2 != null) {
            head.next = list2;
        }

        return ans.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(2, null);
        node1 = node1.next;
        node1.next = new ListNode(4, null);

        ListNode node2 = new ListNode(1, null);
        ListNode head2 = node2;
        node2.next = new ListNode(3, null);
        node2 = node2.next;
        node2.next = new ListNode(4, null);

        ListNode ans = mergeTwoLists(head1, head2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
