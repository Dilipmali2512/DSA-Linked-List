public class Leetcode23 {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;

        return helper(0, len - 1, lists);
    }

    public static ListNode helper(int start, int end, ListNode[] lists) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode left = helper(start, mid, lists);
        ListNode right = helper(mid + 1, end, lists);

        return mergeSortedNode(left, right);
    }

    public static ListNode mergeSortedNode(ListNode leftNode, ListNode rightNode) {
        ListNode head = new ListNode(-1, null);
        ListNode mainNode = head;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val > rightNode.val) {
                head.next = new ListNode(rightNode.val, null);
                rightNode = rightNode.next;
                head = head.next;
            } else {
                head.next = new ListNode(leftNode.val, null);
                leftNode = leftNode.next;
                head = head.next;
            }
        }

        while (leftNode != null) {
            head.next = new ListNode(leftNode.val, null);
            leftNode = leftNode.next;
            head = head.next;
        }

        while (rightNode != null) {
            head.next = new ListNode(rightNode.val, null);
            rightNode = rightNode.next;
            head = head.next;
        }

        return mainNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(4, null);
        node1 = node1.next;
        node1.next = new ListNode(5, null);

        ListNode node2 = new ListNode(1, null);
        ListNode head2 = node2;
        node2.next = new ListNode(3, null);
        node2 = node2.next;
        node2.next = new ListNode(4, null);

        ListNode node3 = new ListNode(2, null);
        ListNode head3 = node3;
        node3.next = new ListNode(6, null);
        node3 = node3.next;
        // node3.next = new ListNode(, null);

        ListNode ans = mergeKLists(new ListNode[] { head1, head2, head3 });

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
