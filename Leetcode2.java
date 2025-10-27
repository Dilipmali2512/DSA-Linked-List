public class Leetcode2 {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode ans = new ListNode(-1, null);
        ListNode head = ans;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + pre;
            ans.next = new ListNode(sum % 10, null);
            ans = ans.next;
            pre = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + pre;
            ans.next = new ListNode(sum % 10, null);
            ans = ans.next;
            pre = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + pre;
            ans.next = new ListNode(sum % 10, null);
            ans = ans.next;
            pre = sum / 10;
            l2 = l2.next;
        }

        if (pre > 0) {
            ans.next = new ListNode(pre, null);
        }

        return head.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2, null);
        ListNode head1 = node1;
        node1.next = new ListNode(4, null);
        node1 = node1.next;
        node1.next = new ListNode(3, null);

        ListNode node2 = new ListNode(5, null);
        ListNode head2 = node2;
        node2.next = new ListNode(6, null);
        node2 = node2.next;
        node2.next = new ListNode(4, null);

        ListNode ans = addTwoNumbers(head1, head2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}
